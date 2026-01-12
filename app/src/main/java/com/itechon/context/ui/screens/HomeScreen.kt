package com.itechon.context.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import coil.compose.AsyncImage
import coil.imageLoader
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itechon.context.data.model.ItemType
import com.itechon.context.ui.CaptureState
import com.itechon.context.ui.ContextViewModel
import com.itechon.context.ui.components.CaptureConfirmationDialog
import kotlinx.coroutines.launch
import com.itechon.context.ui.components.ContextCard
import com.itechon.context.ui.components.SmartCaptureFab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ContextViewModel
) {
    val contexts by viewModel.contexts.collectAsState()
    val captureState by viewModel.captureState.collectAsState()
    
    var showNewContextDialog by remember { mutableStateOf(false) }
    var showNoteCaptureDialog by remember { mutableStateOf(false) }
    var newContextTitle by remember { mutableStateOf("") }
    var captureNoteContent by remember { mutableStateOf("") }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    // Logo and Branding in Sidebar
                    AsyncImage(
                        model = "file:///android_asset/logo.svg",
                        contentDescription = "Logo",
                        modifier = Modifier.size(64.dp)
                    )
                    // Zero spacing as requested
                    Text(
                        text = "Context",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    NavigationDrawerItem(
                        label = { Text("Home") },
                        selected = true,
                        onClick = { 
                            scope.launch { drawerState.close() }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Search") },
                        selected = false,
                        onClick = { 
                            navController.navigate("search")
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Contexts") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate("search") }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    }
                )
            },
            floatingActionButton = {
                SmartCaptureFab(
                    onCaptureNote = { showNoteCaptureDialog = true },
                    onCapturePhoto = { /* Mock photo capture */ },
                    onCaptureAudio = { /* Mock audio capture */ }
                )
            }
        ) { padding ->
            LazyColumn(contentPadding = padding) {
                items(contexts) { context ->
                    ContextCard(context = context) {
                        navController.navigate("context_detail/${context.id}")
                    }
                }
            }
    
            // Dialog for entering note content
            if (showNoteCaptureDialog) {
                AlertDialog(
                    onDismissRequest = { showNoteCaptureDialog = false },
                    title = { Text("New Note") },
                    text = {
                        OutlinedTextField(
                            value = captureNoteContent,
                            onValueChange = { captureNoteContent = it },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("What's on your mind?") }
                        )
                    },
                    confirmButton = {
                        Button(onClick = {
                            viewModel.startCapture(ItemType.NOTE, content = captureNoteContent)
                            captureNoteContent = ""
                            showNoteCaptureDialog = false
                        }) {
                            Text("Capture")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showNoteCaptureDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
    
            // New Context Dialog
            if (showNewContextDialog) {
                AlertDialog(
                    onDismissRequest = { showNewContextDialog = false },
                    title = { Text("New Context") },
                    text = {
                        OutlinedTextField(
                            value = newContextTitle,
                            onValueChange = { newContextTitle = it },
                            label = { Text("Title") }
                        )
                    },
                    confirmButton = {
                        Button(onClick = {
                            viewModel.createNewContext(newContextTitle)
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
    }
}
