package com.itechon.context.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import coil.compose.AsyncImage
import coil.imageLoader
import androidx.compose.material3.*
import com.itechon.context.ui.components.ItemRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.navigation.NavController
import com.itechon.context.data.model.ItemType
import com.itechon.context.ui.CaptureState
import com.itechon.context.ui.ContextViewModel
import com.itechon.context.ui.components.CaptureConfirmationDialog
import com.itechon.context.worker.SyncWorker
import kotlinx.coroutines.launch
import com.itechon.context.ui.components.ContextCard
import com.itechon.context.ui.components.SmartCaptureFab
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ContextViewModel,
    initialShortcut: String? = null
) {
    val contexts by viewModel.contexts.collectAsState()
    val captureState by viewModel.captureState.collectAsState()
    


    val pinnedContexts = contexts.filter { it.isPinned }
    val recentContexts = contexts.filter { !it.isPinned }.sortedByDescending { it.updatedAt }

    var showNewContextDialog by remember { mutableStateOf(false) }
    var newContextTitle by remember { mutableStateOf("") }
    
    var showSearchBar by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    // Handle initial shortcut action
    LaunchedEffect(initialShortcut) {
        if (initialShortcut == "new_context") {
            showNewContextDialog = true
        } else if (initialShortcut == "search") {
            showSearchBar = true
        }
    }
    
    // Quick Capture States
    var showNoteDialog by remember { mutableStateOf(false) }
    var noteContent by remember { mutableStateOf("") }
    var showTaskDialog by remember { mutableStateOf(false) }
    var taskContent by remember { mutableStateOf("") }
    val isRecording by viewModel.isRecording.collectAsState()
    
    val photoPickerLauncher = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia().let { contract ->
        androidx.activity.compose.rememberLauncherForActivityResult(contract) { uri ->
            uri?.let { viewModel.startCapture(ItemType.PHOTO, mediaUri = it.toString()) }
        }
    }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.startCapture(ItemType.LOCATION)
        } else {
             // Handle detail (maybe show snackbar)
        }
    }

    val filteredRecent = remember(recentContexts, searchQuery) {
        recentContexts.filter { searchQuery.isBlank() || it.title.contains(searchQuery, ignoreCase = true) }
    }
    val filteredPinned = remember(pinnedContexts, searchQuery) {
        pinnedContexts.filter { searchQuery.isBlank() || it.title.contains(searchQuery, ignoreCase = true) }
    }
    


    var isRefreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            if (showSearchBar) {
                 TopAppBar(
                    title = {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { 
                                searchQuery = it 
                                // Call viewmodel search logic here if needed
                            },
                            placeholder = { Text("Search contexts...") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                                unfocusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                                focusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
                                unfocusedBorderColor = androidx.compose.ui.graphics.Color.Transparent
                            ),
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            trailingIcon = { 
                                IconButton(onClick = { 
                                    showSearchBar = false 
                                    searchQuery = ""
                                }) {
                                    Icon(Icons.Default.Close, contentDescription = "Close Search")
                                }
                            }
                        )
                    }
                 )
            } else {
                if (isRefreshing) {
                     // Show simple top bar during refresh or scroll?
                     // Actually, we want a clean look.
                     TopAppBar(title = { Text("") }, colors = TopAppBarDefaults.topAppBarColors(containerColor = androidx.compose.ui.graphics.Color.Transparent))
                } else {
                     // Minimal Top Bar for Search Icon access
                     TopAppBar(
                        title = {},
                        actions = {
                            IconButton(onClick = { showSearchBar = true }) {
                                Icon(Icons.Default.Search, contentDescription = "Search Contexts")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = androidx.compose.ui.graphics.Color.Transparent)
                     )
                }
            }
        },
        floatingActionButton = {
            SmartCaptureFab(
                onCaptureNote = { showNoteDialog = true },
                onCapturePhoto = {
                    photoPickerLauncher.launch(
                        androidx.activity.result.PickVisualMediaRequest(androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                },
                onCaptureTask = { showTaskDialog = true },
                onCaptureLocation = {
                     if (androidx.core.content.ContextCompat.checkSelfPermission(
                            context,
                            android.Manifest.permission.ACCESS_FINE_LOCATION
                        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
                    ) {
                        viewModel.startCapture(ItemType.LOCATION)
                    } else {
                        locationPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                },
                onCaptureAudio = {
                    if (isRecording) {
                        viewModel.stopAudioRecording(null) // Stop and save
                    } else {
                        viewModel.startAudioRecording()
                    }
                }
            )
        }
    ) { padding ->
        PullToRefreshBox(
            isRefreshing = isRefreshing,
            onRefresh = {
                isRefreshing = true
                val workRequest = OneTimeWorkRequestBuilder<SyncWorker>().build()
                WorkManager.getInstance(context).enqueue(workRequest)
                scope.launch {
                    kotlinx.coroutines.delay(1500) // Simulate sync wait for UX
                    isRefreshing = false
                }
            },
            modifier = Modifier.padding(padding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Hero Header
                item(span = { GridItemSpan(2) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .background(
                                brush = androidx.compose.ui.graphics.Brush.linearGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.surfaceVariant,
                                        MaterialTheme.colorScheme.surface
                                    )
                                ),
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                text = "Welcome Back",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                            Text(
                                text = "My Contexts",
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        
                        // Decorative Icon
                        Icon(
                            imageVector = Icons.Default.CloudQueue,
                            contentDescription = null,
                            modifier = Modifier
                                .align(androidx.compose.ui.Alignment.TopEnd)
                                .padding(24.dp)
                                .size(64.dp)
                                .graphicsLayer { alpha = 0.1f }, // Transparent aesthetic
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                
                if (filteredPinned.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Text(
                            "Pinned",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    items(filteredPinned) { context ->
                         ContextCard(
                            context = context,
                            onClick = { navController.navigate("context_detail/${context.id}") }
                        )
                    }
                }

                if (filteredRecent.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Text(
                            "Recent",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    items(filteredRecent) { context ->
                        ContextCard(
                            context = context,
                            onClick = { navController.navigate("context_detail/${context.id}") }
                        )
                    }
                }
                
                if (filteredRecent.isEmpty() && filteredPinned.isEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CloudQueue,
                                contentDescription = null,
                                modifier = Modifier.size(64.dp),
                                tint = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "No contexts found",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Tap the + button to create one.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
                
                item(span = { GridItemSpan(2) }) { Spacer(modifier = Modifier.height(100.dp)) }
            }
        }
    }

    // New Context Dialog
    if (showNewContextDialog) {
        var selectedColor by remember { mutableStateOf<Int?>(null) }
        val colors = listOf(
            0xFFF8BBD0.toInt(), // Pink
            0xFFE1BEE7.toInt(), // Purple
            0xFFD1C4E9.toInt(), // Deep Purple
            0xFFC5CAE9.toInt(), // Indigo
            0xFFBBDEFB.toInt(), // Blue
            0xFFB3E5FC.toInt(), // Light Blue
            0xFFB2EBF2.toInt(), // Cyan
            0xFFB2DFDB.toInt(), // Teal
            0xFFC8E6C9.toInt(), // Green
            0xFFDCEDC8.toInt(), // Light Green
        )

        AlertDialog(
            onDismissRequest = { showNewContextDialog = false },
            title = { Text("New Context") },
            text = {
                Column {
                    OutlinedTextField(
                        value = newContextTitle,
                        onValueChange = { newContextTitle = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Color Code", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        colors.take(5).forEach { color ->
                                Surface(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable { selectedColor = color },
                                shape = androidx.compose.foundation.shape.CircleShape,
                                color = androidx.compose.ui.graphics.Color(color),
                                border = if (selectedColor == color) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null
                            ) {}
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        colors.takeLast(5).forEach { color ->
                                Surface(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable { selectedColor = color },
                                shape = androidx.compose.foundation.shape.CircleShape,
                                color = androidx.compose.ui.graphics.Color(color),
                                border = if (selectedColor == color) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null
                            ) {}
                        }
                    }
                }
            },


            confirmButton = {
                Button(onClick = {
                    viewModel.createNewContext(newContextTitle, selectedColor)
                    newContextTitle = ""
                    showNewContextDialog = false
                }) {
                    Text("Create")
                }
            },
            dismissButton = {
                TextButton(onClick = { showNewContextDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Quick Note Dialog
    if (showNoteDialog) {
        AlertDialog(
            onDismissRequest = { showNoteDialog = false },
            title = { Text("Quick Note") },
            text = {
                OutlinedTextField(
                    value = noteContent,
                    onValueChange = { noteContent = it },
                    label = { Text("What's on your mind?") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3,
                    maxLines = 5
                )
            },
            confirmButton = {
                Button(onClick = {
                    if (noteContent.isNotBlank()) {
                        viewModel.startCapture(ItemType.NOTE, content = noteContent)
                        noteContent = ""
                        showNoteDialog = false
                    }
                }) {
                    Text("Capture")
                }
            },
            dismissButton = {
                TextButton(onClick = { showNoteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Task Dialog
    if (showTaskDialog) {
        AlertDialog(
            onDismissRequest = { showTaskDialog = false },
            title = { Text("New Task") },
            text = {
                OutlinedTextField(
                    value = taskContent,
                    onValueChange = { taskContent = it },
                    label = { Text("What needs to be done?") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            },
            confirmButton = {
                Button(onClick = {
                    if (taskContent.isNotBlank()) {
                        viewModel.startCapture(ItemType.TASK, content = taskContent)
                        taskContent = ""
                        showTaskDialog = false
                    }
                }) {
                    Text("Add Task")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTaskDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Suggestion Flow
    when (val state = captureState) {
        is CaptureState.ConfirmingContext -> {
            CaptureConfirmationDialog(
                item = state.item,
                suggestions = state.suggestions,
                onConfirm = { contextId ->
                    viewModel.confirmCapture(state.item, contextId)
                },
                onCancel = { viewModel.cancelCapture() },
                onNewContext = {
                    showNewContextDialog = true
                }
            )
        }
        else -> {}
    }
}
