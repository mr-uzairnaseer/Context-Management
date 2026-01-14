package com.itechon.context.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.ui.ContextViewModel

import com.itechon.context.data.model.ItemType
import com.itechon.context.ui.components.ItemRow
import androidx.navigation.NavController

import kotlinx.datetime.Clock
import android.text.format.DateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContextDetailScreen(
    contextId: String,
    viewModel: ContextViewModel,
    navController: NavController
) {
    // We need to fetch the context details to show the title. 
    // Assuming we can get it from the list or modify ViewModel to fetch single context.
    // For now, we'll try to find it in the list (sub-optimal but works for MVP without repo changes)
    val contexts by viewModel.contexts.collectAsState()
    val currentContext = contexts.find { it.id == contextId }
    
    val items by viewModel.getItemsForContext(contextId).collectAsState(initial = emptyList())
    var newNoteContent by remember { mutableStateOf(androidx.compose.ui.text.input.TextFieldValue("")) } // Changed to TextFieldValue for better cursor control
    
    // Speech to Text Launcher
    val speechLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
        contract = androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            val data = result.data
            val results = data?.getStringArrayListExtra(android.speech.RecognizerIntent.EXTRA_RESULTS)
            val spokenText = results?.get(0)
            if (!spokenText.isNullOrBlank()) {
                val currentText = newNoteContent.text
                val separator = if (currentText.isNotEmpty() && !currentText.endsWith(" ")) " " else ""
                newNoteContent = androidx.compose.ui.text.input.TextFieldValue(
                    text = currentText + separator + spokenText,
                    selection = androidx.compose.ui.text.TextRange(currentText.length + separator.length + spokenText.length)
                )
            }
        }
    }
    
    var showEditDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var editTitle by remember { mutableStateOf("") }

    // Update editTitle when context changes or dialog opens
    LaunchedEffect(currentContext, showEditDialog) {
        if (showEditDialog && currentContext != null) {
            editTitle = currentContext.title
        }
    }

    val calendarEvents by viewModel.currentCalendarEvents.collectAsState()
    val availableCalendars by viewModel.availableCalendars.collectAsState()
    var showCalendarDialog by remember { mutableStateOf(false) }
    var showReminderDialog by remember { mutableStateOf(false) }
    var showAttachmentMenu by remember { mutableStateOf(false) } // For Bottom Bar

    LaunchedEffect(contextId) {
        viewModel.loadCalendarEvents(contextId)
    }

    val exportedPdfFile by viewModel.exportedPdfFile.collectAsState()
    val context = androidx.compose.ui.platform.LocalContext.current
    LaunchedEffect(exportedPdfFile) {
        exportedPdfFile?.let { file ->
            val uri = androidx.core.content.FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
            val intent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(android.content.Intent.EXTRA_STREAM, uri)
                addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(android.content.Intent.createChooser(intent, "Share Context Report"))
            viewModel.clearExportedPdf()
        }
    }


    // Local state for filtering and search
    var searchQuery by remember { mutableStateOf("") }
    var selectedTypeFilter by remember { mutableStateOf<ItemType?>(null) } // null = All

    // Filter logic
    val filteredItems = remember(items, searchQuery, selectedTypeFilter) {
        items.filter { item ->
            val matchesType = selectedTypeFilter == null || item.type == selectedTypeFilter
            val matchesSearch = searchQuery.isBlank() || 
                (item.content?.contains(searchQuery, ignoreCase = true) == true) ||
                (item.type.name.contains(searchQuery, ignoreCase = true))
            matchesType && matchesSearch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { }, // Title is in Hero Header now
                navigationIcon = {
                    FilledTonalIconButton(
                        onClick = { navController.navigateUp() },
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                            contentColor = MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = androidx.compose.ui.graphics.Color.Transparent,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                ),
                actions = {
                    IconButton(onClick = { showCalendarDialog = true }) {
                         Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Link Calendar",
                            tint = if (currentContext?.linkedCalendarId != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = { showReminderDialog = true }) {
                        Icon(
                            imageVector = if (currentContext?.reminderTimestamp != null) Icons.Default.Alarm else Icons.Outlined.Alarm,
                            contentDescription = "Set Reminder",
                            tint = if (currentContext?.reminderTimestamp != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = { viewModel.toggleContextPin(contextId) }) {
                        Icon(
                            imageVector = if (currentContext?.isPinned == true) Icons.Default.PushPin else Icons.Outlined.PushPin,
                            contentDescription = if (currentContext?.isPinned == true) "Unpin" else "Pin",
                             tint = if (currentContext?.isPinned == true) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = { viewModel.exportPdf(navController.context, contextId) }) {
                        Icon(Icons.Default.Share, contentDescription = "Export PDF")
                    }
                    IconButton(onClick = { showEditDialog = true }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            )
        },
        bottomBar = {
            Surface(tonalElevation = 8.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val isRecording by viewModel.isRecording.collectAsState()
                    val photoPickerLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
                        contract = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia()
                    ) { uri ->
                        uri?.let { viewModel.startCapture(ItemType.PHOTO, mediaUri = it.toString()) }
                    }

                    // Attachment Menu Button
                    Box {
                        IconButton(onClick = { showAttachmentMenu = true }) {
                            Icon(Icons.Default.Add, contentDescription = "Add Attachment", tint = MaterialTheme.colorScheme.primary)
                        }
                        DropdownMenu(
                            expanded = showAttachmentMenu,
                            onDismissRequest = { showAttachmentMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Take Photo") },
                                onClick = {
                                    showAttachmentMenu = false
                                    // Need Camera permission logic here or separate launcher. 
                                    // For now, re-using photo picker for simplicity as "Add Image"
                                    photoPickerLauncher.launch(
                                         androidx.activity.result.PickVisualMediaRequest(androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                                leadingIcon = { Icon(Icons.Default.CameraAlt, contentDescription = null) }
                            )
                            DropdownMenuItem(
                                text = { Text(if (isRecording) "Stop Recording" else "Record Audio") },
                                onClick = {
                                    showAttachmentMenu = false
                                    if (isRecording) {
                                        viewModel.stopAudioRecording(null)
                                    } else {
                                        viewModel.startAudioRecording()
                                    }
                                },
                                leadingIcon = { 
                                    Icon(
                                        if (isRecording) Icons.Default.Stop else Icons.Default.Mic, 
                                        contentDescription = null,
                                        tint = if (isRecording) MaterialTheme.colorScheme.error else LocalContentColor.current
                                    ) 
                                }
                            )
                            // Future: Add Location
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    
                    OutlinedTextField(
                        value = newNoteContent,
                        onValueChange = { newNoteContent = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Add a note...") },
                        maxLines = 3,
                        shape = MaterialTheme.shapes.extraLarge, // Rounder
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            focusedLabelColor = MaterialTheme.colorScheme.primary,
                            cursorColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                        ),
                        trailingIcon = {
                             IconButton(onClick = {
                                 val intent = android.content.Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                                     putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                                 }
                                 try {
                                     speechLauncher.launch(intent)
                                 } catch (e: Exception) {
                                     // Handle failure
                                 }
                             }) {
                                 Icon(Icons.Default.Mic, contentDescription = "Voice Input")
                             }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    // Send Button
                    FilledTonalIconButton(
                        onClick = {
                            if (newNoteContent.text.isNotBlank()) {
                                viewModel.addNoteToContext(contextId, newNoteContent.text)
                                newNoteContent = androidx.compose.ui.text.input.TextFieldValue("")
                            }
                        },
                        enabled = newNoteContent.text.isNotBlank()
                    ) {
                        Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Add Note")
                    }
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
        ) {
            // Search and Filter Section
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search items...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.primary
                    ),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(modifier = Modifier.horizontalScroll(androidx.compose.foundation.rememberScrollState())) {
                    FilterChip(
                        selected = selectedTypeFilter == null,
                        onClick = { selectedTypeFilter = null },
                        label = { Text("All") },
                        leadingIcon = if (selectedTypeFilter == null) {
                            { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
                        } else null,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    ItemType.values().forEach { type ->
                        FilterChip(
                            selected = selectedTypeFilter == type,
                            onClick = { selectedTypeFilter = if (selectedTypeFilter == type) null else type },
                            label = { 
                                Text(
                                    text = type.name.lowercase().capitalize(),
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            leadingIcon = if (selectedTypeFilter == type) {
                                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
                            } else null,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

            if (filteredItems.isEmpty() && calendarEvents.isEmpty()) {
                 Box(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (searchQuery.isNotBlank() || selectedTypeFilter != null) {
                             Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.outline, modifier = Modifier.size(48.dp))
                             Spacer(modifier = Modifier.height(8.dp))
                             Text("No results found.", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.outline)
                        } else {
                            Text("No items yet.", style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Start capturing to see your timeline.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.outline)
                        }
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(0.dp), // Remove default padding for Hero
                    modifier = Modifier.weight(1f)
                ) {
                    // HERO HEADER
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                        ) {
                            // Background
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        if (currentContext?.color != null) androidx.compose.ui.graphics.Color(currentContext.color) 
                                        else MaterialTheme.colorScheme.primaryContainer
                                    )
                            )
                            // Gradient
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        androidx.compose.ui.graphics.Brush.verticalGradient(
                                            colors = listOf(
                                                androidx.compose.ui.graphics.Color.Transparent,
                                                MaterialTheme.colorScheme.background // Fade to background
                                            )
                                        )
                                    )
                            )
                            
                            // Content
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = currentContext?.title ?: "Context Detail",
                                    style = MaterialTheme.typography.displaySmall,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground // Since we fade to background
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Started ${currentContext?.startTime?.toString()?.substringBefore("T") ?: "Unknown"}",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }

                    // REST OF CONTENT (with padding restored via column/items)

                    // Calendar Events Header
                    if (calendarEvents.isNotEmpty()) {
                        item {
                             Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
                                Text(
                                    text = "Today's Events",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                             }
                        }
                        items(calendarEvents) { event ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = event.title,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                                    )
                                    val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm")
                                    val start = java.time.Instant.ofEpochMilli(event.startTime).atZone(java.time.ZoneId.systemDefault())
                                    val end = java.time.Instant.ofEpochMilli(event.endTime).atZone(java.time.ZoneId.systemDefault())
                                    Text(
                                        text = "${formatter.format(start)} - ${formatter.format(end)}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                    if (!event.location.isNullOrBlank()) {
                                        Text(
                                            text = event.location,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                }
                            }
                        }
                        item {
                            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                        }
                    }
    
    
                    // Info Header removed (moved to Hero)

    
                    items(filteredItems) { item ->
                        ItemRow(
                            item = item, 
                            viewModel = viewModel,
                            onImageClick = { url ->
                                val encodedUrl = java.net.URLEncoder.encode(url, "UTF-8")
                                navController.navigate("image_viewer/$encodedUrl")
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Spacing between rows
                    }
                }
            }
        }
    }

    if (showCalendarDialog) {
        AlertDialog(
            onDismissRequest = { showCalendarDialog = false },
            title = { Text("Link Calendar") },
            text = {
                LazyColumn(modifier = Modifier.heightIn(max = 300.dp)) {
                    if (availableCalendars.isEmpty()) {
                        item { Text("No calendars found or permission denied.") }
                    } else {
                        items(availableCalendars) { calendar ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.linkCalendar(contextId, calendar.id)
                                        showCalendarDialog = false
                                    }
                                    .padding(vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    modifier = Modifier.size(16.dp),
                                    shape = androidx.compose.foundation.shape.CircleShape,
                                    color = androidx.compose.ui.graphics.Color(calendar.color)
                                ) {}
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(calendar.displayName, style = MaterialTheme.typography.bodyLarge)
                                    Text(calendar.accountName, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.outline)
                                }
                                if (currentContext?.linkedCalendarId == calendar.id) {
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(Icons.Default.Check, contentDescription = "Selected", tint = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showCalendarDialog = false }) {
                    Text("Close")
                }
            }
        )
    }

    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text("Edit Context Title") },
            text = {
                OutlinedTextField(
                    value = editTitle,
                    onValueChange = { editTitle = it },
                    label = { Text("Title") },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (editTitle.isNotBlank()) {
                            viewModel.updateContextTitle(contextId, editTitle)
                            showEditDialog = false
                        }
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Context") },
            text = { Text("Are you sure you want to delete this context? This action cannot be undone.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.deleteContext(contextId)
                        showDeleteDialog = false
                        navController.popBackStack() 
                    },
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showReminderDialog) {
        val dateParams = rememberDatePickerState(
             initialSelectedDateMillis = currentContext?.reminderTimestamp ?: Clock.System.now().toEpochMilliseconds()
        )
        var showTimePicker by remember { mutableStateOf(false) }
        
        // Use a Calendar to extract hour/minute from timestamp if exists, or current time
        val calendar = java.util.Calendar.getInstance()
        if (currentContext?.reminderTimestamp != null) {
            calendar.timeInMillis = currentContext.reminderTimestamp
        }
        val timeState = rememberTimePickerState(
            initialHour = calendar.get(java.util.Calendar.HOUR_OF_DAY),
            initialMinute = calendar.get(java.util.Calendar.MINUTE),
            is24Hour = DateFormat.is24HourFormat(context)
        )

        if (showTimePicker) {
             AlertDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        val selectedDate = dateParams.selectedDateMillis ?: return@TextButton
                        
                        // Combine Date and Time
                        val c = java.util.Calendar.getInstance()
                        c.timeInMillis = selectedDate
                        c.set(java.util.Calendar.HOUR_OF_DAY, timeState.hour)
                        c.set(java.util.Calendar.MINUTE, timeState.minute)
                        c.set(java.util.Calendar.SECOND, 0)
                        
                        viewModel.scheduleReminder(context, contextId, c.timeInMillis)
                        showTimePicker = false
                        showReminderDialog = false
                    }) { Text("Set Alarm") }
                },
                dismissButton = {
                    TextButton(onClick = { showTimePicker = false }) { Text("Back") }
                },
                text = {
                     Column(horizontalAlignment = Alignment.CenterHorizontally) {
                         TimePicker(state = timeState)
                     }
                }
            )
        } else {
            DatePickerDialog(
                onDismissRequest = { showReminderDialog = false },
                confirmButton = {
                    TextButton(onClick = { showTimePicker = true }) {
                        Text("Next")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showReminderDialog = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                 DatePicker(state = dateParams)
                 if (currentContext?.reminderTimestamp != null) {
                      Button(
                          onClick = { 
                              viewModel.cancelReminder(context, contextId) 
                              showReminderDialog = false 
                          },
                          colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                          modifier = Modifier.padding(16.dp).fillMaxWidth()
                      ) {
                          Text("Remove Reminder")
                      }
                 }
            }
        }
    }
}
