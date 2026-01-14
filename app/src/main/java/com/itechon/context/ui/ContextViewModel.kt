package com.itechon.context.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.data.model.ItemType
import com.itechon.context.data.repository.ContextRepository
import com.itechon.context.data.repository.ItemRepository
import com.itechon.context.data.repository.CalendarRepository
import com.itechon.context.data.repository.CalendarInfo
import com.itechon.context.data.repository.CalendarEvent
import com.itechon.context.data.repository.OCRHelper
import com.itechon.context.data.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import java.util.UUID
import kotlinx.coroutines.ExperimentalCoroutinesApi

sealed class CaptureState {
    object Idle : CaptureState()
    data class ContentCaptured(val type: ItemType, val content: String? = null, val mediaUri: String? = null) : CaptureState()
    data class ConfirmingContext(val item: ItemEntity, val suggestions: List<ContextEntity>) : CaptureState()
}

class ContextViewModel(
    val repository: ContextRepository, // Made public for direct access in MVP (e.g. ProfileScreen clearing)
    private val itemRepository: ItemRepository,
    private val calendarRepository: CalendarRepository,
    private val ocrHelper: OCRHelper,
    private val audioHelper: com.itechon.context.utils.AudioHelper,
    private val locationHelper: com.itechon.context.utils.LocationHelper,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {



    class Factory(
        private val repository: ContextRepository,
        private val itemRepository: ItemRepository,
        private val calendarRepository: CalendarRepository,
        private val ocrHelper: OCRHelper,
        private val audioHelper: com.itechon.context.utils.AudioHelper,
        private val locationHelper: com.itechon.context.utils.LocationHelper,
        private val userPreferencesRepository: UserPreferencesRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContextViewModel::class.java)) {
                return ContextViewModel(repository, itemRepository, calendarRepository, ocrHelper, audioHelper, locationHelper, userPreferencesRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


    private val _captureState = MutableStateFlow<CaptureState>(CaptureState.Idle)
    val captureState = _captureState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    // Theme Persistence
    val isDarkTheme: StateFlow<Boolean> = userPreferencesRepository.isDarkTheme
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false) // Default to Light Mode

    fun toggleTheme(isDark: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveThemePreference(isDark)
        }
    }

    // Biometric Security
    val isBiometricEnabled: StateFlow<Boolean> = userPreferencesRepository.isBiometricEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun toggleBiometric(isEnabled: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveBiometricPreference(isEnabled)
        }
    }
    
    // Onboarding
    val isOnboardingCompleted: StateFlow<Boolean> = userPreferencesRepository.isOnboardingCompleted
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false) // Default false until loaded

    fun completeOnboarding() {
        viewModelScope.launch {
            userPreferencesRepository.saveOnboardingCompleted(true)
        }
    }

    private val _isRecording = MutableStateFlow(false)
    val isRecording = _isRecording.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _exportedPdfFile = MutableStateFlow<java.io.File?>(null)
    val exportedPdfFile = _exportedPdfFile.asStateFlow()


    @OptIn(ExperimentalCoroutinesApi::class)
    val searchResults: StateFlow<List<ItemEntity>> = _searchQuery
        .debounce(300)
        .flatMapLatest { query ->
            if (query.length < 2) kotlinx.coroutines.flow.flowOf(emptyList())
            else itemRepository.searchItems(query)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val contexts: StateFlow<List<ContextEntity>> = repository.allContexts
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allItems: StateFlow<List<ItemEntity>> = itemRepository.getAllItems()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>> {
        return itemRepository.getItemsForContext(contextId)
    }

    fun startCapture(type: ItemType, content: String? = null, mediaUri: String? = null) {
        viewModelScope.launch {
            _isLoading.value = true
            var detectedText = content
            var lat: Double? = null
            var lng: Double? = null
            
            // AI Feature: OCR
            if (type == ItemType.PHOTO && mediaUri != null) {
                val scanned = ocrHelper.processImage(android.net.Uri.parse(mediaUri))
                if (!scanned.isNullOrBlank()) {
                    detectedText = scanned
                }
            }

            if (type == ItemType.LOCATION) {
                val loc = locationHelper.getCurrentLocation()
                if (loc != null) {
                    lat = loc.latitude
                    lng = loc.longitude
                    detectedText = "Pinned Location"
                } else {
                     detectedText = "Location Unavailable"
                }
            }

            val now = Clock.System.now()
            val newItem = ItemEntity(
                id = UUID.randomUUID().toString(),
                type = type,
                content = detectedText,
                mediaUri = mediaUri,
                timestamp = now,
                locationLat = lat,
                locationLng = lng,
                syncStatus = "DIRTY"
            )
            
            val currentContexts = contexts.value
            // Simple heuristic for suggestions: last 3 updated contexts
            val suggestions = currentContexts.take(3)
            
            _captureState.value = CaptureState.ConfirmingContext(newItem, suggestions)
            _isLoading.value = false
        }
    }

    fun confirmCapture(item: ItemEntity, contextId: String) {
        viewModelScope.launch {
            val confirmedItem = item.copy(contextId = contextId)
            repository.createItem(confirmedItem)
            _captureState.value = CaptureState.Idle
        }
    }

    fun cancelCapture() {
        _captureState.value = CaptureState.Idle
    }

    fun performRemoteSearch(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // In a real app, generate embedding first (via edge function or locally)
                // For MVP we call the match_contexts RPC directly if we had the embedding
                // Since embedding generation is complex on device, we mock the result for now
                // or just call a filtered local search which we already have in the UI.
                
                // Mocking a delay for semantic search
                kotlinx.coroutines.delay(1000)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun createNewContext(title: String, color: Int?) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val newContext = ContextEntity(
                id = UUID.randomUUID().toString(),
                title = title,
                createdAt = now,
                updatedAt = now,
                syncStatus = "DIRTY",
                color = color
            )
            repository.createContext(newContext)
        }
    }

    fun addNoteToContext(contextId: String, content: String) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val newItem = ItemEntity(
                id = UUID.randomUUID().toString(),
                type = ItemType.NOTE,
                content = content,
                timestamp = now,
                contextId = contextId,
                syncStatus = "DIRTY"
            )
            repository.createItem(newItem)
        }
    }

    fun toggleTaskCompletion(item: ItemEntity) {
        viewModelScope.launch {
            val updatedItem = item.copy(
                isCompleted = !item.isCompleted,
                syncStatus = "DIRTY"
            )
            itemRepository.updateItem(updatedItem)
        }
    }

    fun startAudioRecording() {
        viewModelScope.launch {
            audioHelper.startRecording()
            _isRecording.value = true
        }
    }

    fun stopAudioRecording(file: java.io.File?) {
        viewModelScope.launch {
            audioHelper.stopRecording()
            _isRecording.value = false
            if (file != null) {
                val now = Clock.System.now()
                val newItem = ItemEntity(
                    id = UUID.randomUUID().toString(),
                    type = ItemType.AUDIO,
                    content = "Voice note at ${now}",
                    mediaUri = android.net.Uri.fromFile(file).toString(),
                    timestamp = now,
                    syncStatus = "DIRTY"
                )
                // In a real flow, this would go through the startCapture -> confirm dialog
                // but for now let's just use the current context if we are in DetailScreen,
                // or the suggestion flow.
                _captureState.value = CaptureState.ConfirmingContext(newItem, contexts.value.take(3))
            }
        }
    }

    fun playAudio(uriString: String) {
        audioHelper.playAudio(android.net.Uri.parse(uriString))
    }

    // Audio Playback State
    val currentPlayingUri = audioHelper.currentPlayingUri
    val isAudioPlaying = audioHelper.isPlaying
    val audioProgress = audioHelper.progress

    fun triggerManualSync() {
        // In a real app, we'd enqueue a OneTimeWorkRequest.
        // For MVP, we can try to rely on the scheduled worker or just force a work request.
        // Or better, since we have the worker, let's use WorkManager to enqueue a one-time sync immediately.
        // However, accessing WorkManager from ViewModel needs Context.
        // Alternatively, we could have a suspend function in Repo that does the sync logic, but SyncWorker logic is in the worker.
        // Let's just expose a boolean to show we are syncing if we were doing it manually?
        // Actually, easiest way is to use WorkManager in the UI (Composable) or pass Application to AndroidViewModel.
    }

    fun deleteContext(contextId: String) {
        viewModelScope.launch {
            val contextToDelete = contexts.value.find { it.id == contextId }
            if (contextToDelete != null) {
                repository.deleteContext(contextToDelete)
            }
        }
    }

    fun updateContextTitle(contextId: String, newTitle: String) {
        viewModelScope.launch {
            val contextToUpdate = contexts.value.find { it.id == contextId }
            if (contextToUpdate != null) {
                val updatedContext = contextToUpdate.copy(
                    title = newTitle,
                    updatedAt = Clock.System.now(),
                    syncStatus = "DIRTY"
                )
                repository.updateContext(updatedContext)
            }
        }
    }

    fun toggleContextPin(contextId: String) {
        viewModelScope.launch {
            val contextToUpdate = contexts.value.find { it.id == contextId }
            if (contextToUpdate != null) {
                val updatedContext = contextToUpdate.copy(
                    isPinned = !contextToUpdate.isPinned,
                    updatedAt = Clock.System.now(),
                    syncStatus = "DIRTY"
                )
                repository.updateContext(updatedContext)
            }
        }
    }

    val availableCalendars = MutableStateFlow<List<CalendarInfo>>(emptyList())
    val currentCalendarEvents = MutableStateFlow<List<CalendarEvent>>(emptyList())

    init {
        viewModelScope.launch {
            availableCalendars.value = calendarRepository.getAvailableCalendars()
        }
    }

    fun loadCalendarEvents(contextId: String) {
        viewModelScope.launch {
            val context = contexts.value.find { it.id == contextId }
            if (context?.linkedCalendarId != null) {
                currentCalendarEvents.value = calendarRepository.getTodayEvents(context.linkedCalendarId)
            } else {
                currentCalendarEvents.value = emptyList()
            }
        }
    }

    fun linkCalendar(contextId: String, calendarId: Long) {
        viewModelScope.launch {
            val contextToUpdate = contexts.value.find { it.id == contextId }
            if (contextToUpdate != null) {
                val updatedContext = contextToUpdate.copy(
                    linkedCalendarId = calendarId,
                    updatedAt = Clock.System.now(),
                    syncStatus = "DIRTY"
                )
                repository.updateContext(updatedContext)
                // Reload events immediately
                currentCalendarEvents.value = calendarRepository.getTodayEvents(calendarId)
            }
        }
    }

    fun exportPdf(androidContext: android.content.Context, contextId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val contextEntity = contexts.value.find { it.id == contextId }
            if (contextEntity != null) {
                // Collect one-shot items list
                try {
                    val items = itemRepository.getItemsForContext(contextId).first()
                    val file = com.itechon.context.utils.PdfHelper.generateContextReport(androidContext, contextEntity, items)
                    _exportedPdfFile.value = file
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            _isLoading.value = false
        }
    }

    fun clearExportedPdf() {
        _exportedPdfFile.value = null
    }


    private val _exportedBackupFile = MutableStateFlow<java.io.File?>(null)
    val exportedBackupFile = _exportedBackupFile.asStateFlow()

    fun exportAllDataJSON(cacheDir: java.io.File) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val allContexts = contexts.value
                val allItemsList = allItems.value

                val contextBackups = allContexts.map { 
                    com.itechon.context.data.model.ContextBackup(
                        id = it.id,
                        title = it.title,
                        createdAt = it.createdAt.toEpochMilliseconds(),
                        updatedAt = it.updatedAt.toEpochMilliseconds(),
                        isPinned = it.isPinned,
                        color = it.color
                    )
                }

                val itemBackups = allItemsList.map {
                    com.itechon.context.data.model.ItemBackup(
                        id = it.id,
                        contextId = it.contextId ?: "",
                        type = it.type.name,
                        content = it.content,
                        mediaUri = it.mediaUri,
                        timestamp = it.timestamp.toEpochMilliseconds(),
                        isCompleted = it.isCompleted
                    )
                }

                val backupData = com.itechon.context.data.model.BackupData(
                    timestamp = Clock.System.now().toEpochMilliseconds(),
                    contexts = contextBackups,
                    items = itemBackups
                )

                val json = kotlinx.serialization.json.Json { prettyPrint = true }
                val jsonString = json.encodeToString(com.itechon.context.data.model.BackupData.serializer(), backupData)

                val file = java.io.File(cacheDir, "context_backup_${Clock.System.now().toEpochMilliseconds()}.json")
                file.writeText(jsonString)

                _exportedBackupFile.value = file
            } catch (e: Exception) {
                e.printStackTrace()
            }
            _isLoading.value = false
        }
    }

    fun onExportCompleted() {
        _exportedBackupFile.value = null
    }

    fun importDataJSON(uri: android.net.Uri, context: android.content.Context) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val jsonString = context.contentResolver.openInputStream(uri)?.use { 
                    it.bufferedReader().readText() 
                } ?: return@launch

                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                val backupData = json.decodeFromString(com.itechon.context.data.model.BackupData.serializer(), jsonString)

                backupData.contexts.forEach { backupContext ->
                    val entity = ContextEntity(
                        id = backupContext.id,
                        title = backupContext.title,
                        createdAt = kotlinx.datetime.Instant.fromEpochMilliseconds(backupContext.createdAt),
                        updatedAt = kotlinx.datetime.Instant.fromEpochMilliseconds(backupContext.updatedAt),
                        isPinned = backupContext.isPinned,
                        color = backupContext.color,
                        syncStatus = "DIRTY" // Mark dirty to sync with Supabase later
                    )
                    repository.createContext(entity)
                }

                backupData.items.forEach { backupItem ->
                    val type = try { ItemType.valueOf(backupItem.type) } catch (e: Exception) { ItemType.NOTE }
                    val entity = ItemEntity(
                        id = backupItem.id,
                        contextId = backupItem.contextId,
                        type = type,
                        content = backupItem.content,
                        mediaUri = backupItem.mediaUri,
                        timestamp = kotlinx.datetime.Instant.fromEpochMilliseconds(backupItem.timestamp),
                        isCompleted = backupItem.isCompleted,
                        syncStatus = "DIRTY"
                    )
                    itemRepository.insertItem(entity) 
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            _isLoading.value = false
        }
    }

    fun scheduleReminder(context: android.content.Context, contextId: String, timestamp: Long) {
        viewModelScope.launch {
            val contextEntity = contexts.value.find { it.id == contextId } ?: return@launch
            val updatedContext = contextEntity.copy(
                reminderTimestamp = timestamp,
                 updatedAt = Clock.System.now(),
                 syncStatus = "DIRTY"
            )
            repository.updateContext(updatedContext)

            val alarmManager = context.getSystemService(android.content.Context.ALARM_SERVICE) as android.app.AlarmManager
            val intent = android.content.Intent(context, com.itechon.context.receiver.ReminderReceiver::class.java).apply {
                putExtra(com.itechon.context.receiver.ReminderReceiver.EXTRA_CONTEXT_ID, contextId)
                putExtra(com.itechon.context.receiver.ReminderReceiver.EXTRA_TITLE, contextEntity.title)
            }
            val pendingIntent = android.app.PendingIntent.getBroadcast(
                context,
                contextId.hashCode(),
                intent,
                android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE
            )

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                if (alarmManager.canScheduleExactAlarms()) {
                     alarmManager.setExactAndAllowWhileIdle(android.app.AlarmManager.RTC_WAKEUP, timestamp, pendingIntent)
                } else {
                     // Log or fallback to inexact
                     alarmManager.setAndAllowWhileIdle(android.app.AlarmManager.RTC_WAKEUP, timestamp, pendingIntent)
                }
            } else {
                alarmManager.setExactAndAllowWhileIdle(android.app.AlarmManager.RTC_WAKEUP, timestamp, pendingIntent)
            }
        }
    }

    fun cancelReminder(context: android.content.Context, contextId: String) {
        viewModelScope.launch {
            val contextEntity = contexts.value.find { it.id == contextId } ?: return@launch
             val updatedContext = contextEntity.copy(
                reminderTimestamp = null,
                 updatedAt = Clock.System.now(),
                 syncStatus = "DIRTY"
            )
            repository.updateContext(updatedContext)

            val alarmManager = context.getSystemService(android.content.Context.ALARM_SERVICE) as android.app.AlarmManager
            val intent = android.content.Intent(context, com.itechon.context.receiver.ReminderReceiver::class.java)
            val pendingIntent = android.app.PendingIntent.getBroadcast(
                context,
                contextId.hashCode(),
                intent,
                android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE
            )
            alarmManager.cancel(pendingIntent)
        }
    }
}
