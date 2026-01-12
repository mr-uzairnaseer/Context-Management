package com.itechon.context.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.data.model.ItemType
import com.itechon.context.data.repository.ContextRepository
import com.itechon.context.data.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import java.util.UUID

sealed class CaptureState {
    object Idle : CaptureState()
    data class ContentCaptured(val type: ItemType, val content: String? = null, val mediaUri: String? = null) : CaptureState()
    data class ConfirmingContext(val item: ItemEntity, val suggestions: List<ContextEntity>) : CaptureState()
}

class ContextViewModel(
    private val repository: ContextRepository,
    private val itemRepository: ItemRepository
) : ViewModel() {

    private val _captureState = MutableStateFlow<CaptureState>(CaptureState.Idle)
    val captureState = _captureState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val contexts: StateFlow<List<ContextEntity>> = repository.allContexts
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun getItemsForContext(contextId: String): Flow<List<ItemEntity>> {
        return itemRepository.getItemsForContext(contextId)
    }

    fun startCapture(type: ItemType, content: String? = null, mediaUri: String? = null) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val newItem = ItemEntity(
                id = UUID.randomUUID().toString(),
                type = type,
                content = content,
                mediaUri = mediaUri,
                timestamp = now,
                syncStatus = "DIRTY"
            )
            
            val currentContexts = contexts.value
            // Simple heuristic for suggestions: last 3 updated contexts
            val suggestions = currentContexts.take(3)
            
            _captureState.value = CaptureState.ConfirmingContext(newItem, suggestions)
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

    fun createNewContext(title: String) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val newContext = ContextEntity(
                id = UUID.randomUUID().toString(),
                title = title,
                createdAt = now,
                updatedAt = now,
                syncStatus = "DIRTY"
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

    class Factory(
        private val repository: ContextRepository,
        private val itemRepository: ItemRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContextViewModel::class.java)) {
                return ContextViewModel(repository, itemRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
