package com.itechon.context.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itechon.context.BuildConfig
import com.itechon.context.data.remote.SupabaseModule
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.launch
import kotlinx.serialization.json.jsonPrimitive
import androidx.compose.ui.graphics.graphicsLayer

import com.itechon.context.ui.ContextViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ContextViewModel? = null // Optional for now to avoid breaking preview if used, but will be passed from Main
) {
    val contexts by viewModel?.contexts?.collectAsState() ?: remember { mutableStateOf(emptyList()) }
    val allItems by viewModel?.allItems?.collectAsState() ?: remember { mutableStateOf(emptyList()) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    // In a real app, you'd fetch the user profile from a ViewModel
    // For MVP, we can try to get the current session user
    val user = remember { SupabaseModule.client.auth.currentSessionOrNull()?.user }
    val userEmail = user?.email ?: "user@example.com"
    val displayName = user?.userMetadata?.get("full_name")?.jsonPrimitive?.content ?: "Context App User"
    val jobTitle = user?.userMetadata?.get("job_title")?.jsonPrimitive?.content ?: ""
    val bio = user?.userMetadata?.get("bio")?.jsonPrimitive?.content ?: ""
    val website = user?.userMetadata?.get("website")?.jsonPrimitive?.content ?: ""

    val avatarUrl = user?.userMetadata?.get("avatar_url")?.jsonPrimitive?.content

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                actions = {
                    IconButton(onClick = { navController.navigate("edit_profile") }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit Profile")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = androidx.compose.foundation.shape.CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(100.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (!avatarUrl.isNullOrBlank()) {
                        coil.compose.AsyncImage(
                            model = avatarUrl,
                            contentDescription = "Profile Picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = displayName,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = userEmail,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.outline
            )
            
             if (jobTitle.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = jobTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            if (bio.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = bio,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
             if (website.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = website,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))

            // Stats Card
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = contexts.size.toString(),
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Contexts",
                            style = MaterialTheme.typography.labelSmall,
                             color = MaterialTheme.colorScheme.outline
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = allItems.size.toString(),
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Items",
                            style = MaterialTheme.typography.labelSmall,
                             color = MaterialTheme.colorScheme.outline
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Rough estimate: text length + 1MB per media
                        val textBytes = allItems.sumOf { it.content?.length ?: 0 }
                        val mediaCount = allItems.count { it.mediaUri != null }
                        val totalBytes = textBytes + (mediaCount * 1024 * 1024) 
                        val storageString = if (totalBytes > 1024 * 1024) "${totalBytes / (1024 * 1024)} MB" else "${totalBytes / 1024} KB"
                        
                        Text(
                            text = storageString, 
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Storage",
                            style = MaterialTheme.typography.labelSmall,
                             color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            // Settings & Features Section
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "System & Data",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                )
                
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                ) {
                    val context = androidx.compose.ui.platform.LocalContext.current
                    Column {
                         val isDarkTheme by viewModel?.isDarkTheme?.collectAsState() ?: mutableStateOf(true) 
                         ListItem(
                            headlineContent = { Text("Appearance") },
                            supportingContent = { Text(if (isDarkTheme) "Dark Cosmos" else "Light Mode", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { 
                                Icon(
                                    imageVector = if (isDarkTheme) Icons.Default.DarkMode else Icons.Default.LightMode, 
                                    contentDescription = null 
                                ) 
                            },
                            trailingContent = { 
                                Switch(
                                    checked = isDarkTheme, 
                                    onCheckedChange = { viewModel?.toggleTheme(it) },
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = MaterialTheme.colorScheme.tertiary,
                                        checkedTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
                                        uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                                        uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                                    )
                                ) 
                            },
                            modifier = Modifier.clickable { viewModel?.toggleTheme(!isDarkTheme) }
                        )
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)

                        val isBiometricEnabled by viewModel?.isBiometricEnabled?.collectAsState() ?: mutableStateOf(false)
                        ListItem(
                            headlineContent = { Text("App Lock") },
                            supportingContent = { Text("Require authentication on launch", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { Icon(Icons.Default.Lock, contentDescription = null) },
                            trailingContent = { 
                                Switch(
                                    checked = isBiometricEnabled, 
                                    onCheckedChange = { viewModel?.toggleBiometric(it) },
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = MaterialTheme.colorScheme.tertiary,
                                        checkedTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
                                        uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                                        uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                                    )
                                ) 
                            },
                            modifier = Modifier.clickable { viewModel?.toggleBiometric(!isBiometricEnabled) }
                        )
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)

                        ListItem(
                            headlineContent = { Text("Productivity Insights") },
                            supportingContent = { Text("View activity & statistics", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { Icon(Icons.Default.BarChart, contentDescription = null) },
                            modifier = Modifier.clickable { 
                                navController.navigate("insights")
                            }
                        )
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
                        
                        val exportedBackupFile by viewModel?.exportedBackupFile?.collectAsState() ?: mutableStateOf(null)
                        LaunchedEffect(exportedBackupFile) {
                            exportedBackupFile?.let { file ->
                                val uri = androidx.core.content.FileProvider.getUriForFile(
                                    context,
                                    "${context.packageName}.fileprovider",
                                    file
                                )
                                val intent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                                    type = "application/json"
                                    putExtra(android.content.Intent.EXTRA_STREAM, uri)
                                    addFlags(android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                }
                                context.startActivity(android.content.Intent.createChooser(intent, "Share Backup"))
                                viewModel?.onExportCompleted()
                            }
                        }

                        ListItem(
                            headlineContent = { Text("Export Data") },
                            supportingContent = { Text("Share JSON backup", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { Icon(Icons.Default.Share, contentDescription = null) },
                            modifier = Modifier.clickable { 
                                viewModel?.exportAllDataJSON(context.cacheDir)
                            }
                        )
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
                        
                        val importLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
                            contract = androidx.activity.result.contract.ActivityResultContracts.GetContent()
                        ) { uri ->
                            uri?.let { viewModel?.importDataJSON(it, context) }
                        }

                         ListItem(
                            headlineContent = { Text("Import Data") },
                            supportingContent = { Text("Restore from JSON backup", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { Icon(Icons.Default.ArrowDownward, contentDescription = null) },
                            modifier = Modifier.clickable { 
                                importLauncher.launch("application/json")
                            }
                        )
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)

                        ListItem(
                            headlineContent = { Text("Feature Request") },
                            supportingContent = { Text("Send feedback via Email", style = MaterialTheme.typography.bodySmall) },
                            leadingContent = { Icon(Icons.Default.Info, contentDescription = null) },
                            modifier = Modifier.clickable { 
                                val intent = android.content.Intent(android.content.Intent.ACTION_SENDTO).apply {
                                    data = android.net.Uri.parse("mailto:feedback@itechon.com") // Only email apps should handle this
                                    putExtra(android.content.Intent.EXTRA_SUBJECT, "Context App Feature Request")
                                }
                                try {
                                    context.startActivity(intent)
                                } catch (e: Exception) {
                                    // Handle no email app found
                                }
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            
            OutlinedButton(
                onClick = {
                    scope.launch {
                        try {
                            viewModel?.repository?.clearAllData()
                            SupabaseModule.client.auth.signOut()
                            navController.navigate("login") {
                                popUpTo("home") { inclusive = true }
                                popUpTo("login") { inclusive = true }
                            }
                        } catch (e: Exception) {
                            // Handle error
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.error,
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.5f))
            ) {
                Text("Sign Out")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Delete Account Button (Policy Requirement)
            var showDeleteDialog by remember { mutableStateOf(false) }

            TextButton(
                onClick = { showDeleteDialog = true },
                colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurfaceVariant)
            ) {
                Text("Delete Account", style = MaterialTheme.typography.labelMedium)
            }

            if (showDeleteDialog) {
                AlertDialog(
                    onDismissRequest = { showDeleteDialog = false },
                    title = { Text("Delete Account") },
                    text = { Text("This action is permanent. Do you want to request the deletion of your account and all associated data?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                val intent = android.content.Intent(android.content.Intent.ACTION_SENDTO).apply {
                                    data = android.net.Uri.parse("mailto:support@itechon.com")
                                    putExtra(android.content.Intent.EXTRA_SUBJECT, "Account Deletion Request: $userEmail")
                                    putExtra(android.content.Intent.EXTRA_TEXT, "I request the deletion of my account (Email: $userEmail) and all associated data.")
                                }
                                try {
                                    context.startActivity(intent)
                                } catch (e: Exception) {
                                    // Handle no email app
                                }
                                showDeleteDialog = false
                            },
                            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Request Deletion")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDeleteDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Version ${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}
