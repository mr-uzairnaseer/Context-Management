package com.itechon.context.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.data.model.ItemType
import com.itechon.context.ui.ContextViewModel
import kotlinx.datetime.toJavaInstant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun ItemRow(
    item: ItemEntity,
    viewModel: ContextViewModel,
    onImageClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp), // Reduced vertical spacing for chat-bubble feel
        shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f) // Glassy
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = when (item.type) {
                        ItemType.NOTE -> Icons.Default.Description
                        ItemType.PHOTO -> Icons.Default.Image
                        ItemType.AUDIO -> Icons.Default.Mic
                        ItemType.TASK -> Icons.Default.CheckCircle
                        ItemType.LOCATION -> Icons.Default.Place
                    },
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                // Date Formatting
                val instant = item.timestamp.toJavaInstant()
                val formatter = java.time.format.DateTimeFormatter.ofPattern("MMM dd, HH:mm").withZone(java.time.ZoneId.systemDefault())
                
                Text(
                    text = formatter.format(instant),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            
            when (item.type) {
                ItemType.NOTE -> {
                    Text(
                        text = item.content ?: "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                ItemType.PHOTO -> {
                    Column {
                        AsyncImage(
                            model = item.mediaUri,
                            contentDescription = "Photo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(MaterialTheme.shapes.medium)
                                .clickable { item.mediaUri?.let { onImageClick(it) } },
                            contentScale = ContentScale.Crop
                        )
                        if (!item.content.isNullOrBlank()) {
                             Spacer(modifier = Modifier.height(8.dp))
                             Surface(
                                 color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                 shape = MaterialTheme.shapes.small
                             ) {
                                 Column(modifier = Modifier.padding(8.dp)) {
                                     Text(
                                         text = "Scanned Text:",
                                         style = MaterialTheme.typography.labelSmall,
                                         color = MaterialTheme.colorScheme.primary
                                     )
                                     Text(
                                         text = item.content,
                                         style = MaterialTheme.typography.bodySmall,
                                         modifier = Modifier.padding(top = 4.dp)
                                     )
                                 }
                             }
                        }
                    }
                }
                ItemType.AUDIO -> {
                    val currentUri by viewModel.currentPlayingUri.collectAsState()
                    val isPlaying by viewModel.isAudioPlaying.collectAsState()
                    val progress by viewModel.audioProgress.collectAsState()
                    val thisUri = item.mediaUri ?: ""
                    val isThisPlaying = currentUri == thisUri && isPlaying
                    val isThisPaused = currentUri == thisUri && !isPlaying
                    
                    Column {
                         Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { item.mediaUri?.let { viewModel.playAudio(it) } }) {
                                Icon(
                                    imageVector = if (isThisPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isThisPlaying) "Pause" else "Play",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                            
                            // Waveform / Progress Visualization
                            Box(modifier = Modifier
                                .weight(1f)
                                .height(32.dp)
                                .padding(horizontal = 8.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                // Background Bars (Static fake waveform)
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    val barCount = 30
                                    repeat(barCount) { index ->
                                        // Deterministic random height based on index
                                        val heightFraction = 0.3f + (Math.sin(index.toDouble() * 0.5).toFloat() + 1f) / 4f
                                        val isPlayed = if (currentUri == thisUri) {
                                            (index.toFloat() / barCount.toFloat()) < progress
                                        } else false
                                        
                                        Box(
                                            modifier = Modifier
                                                .width(3.dp)
                                                .fillMaxHeight(heightFraction)
                                                .clip(MaterialTheme.shapes.extraSmall)
                                                .background(
                                                    if (isPlayed) MaterialTheme.colorScheme.primary 
                                                    else MaterialTheme.colorScheme.primaryContainer
                                                )
                                        )
                                    }
                                }
                            }
                            
                            // Duration / Time
                            Text(
                                text = if (isThisPlaying || isThisPaused) "${(progress * 100).toInt()}%" else "Voice Note",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
                ItemType.TASK -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = item.isCompleted,
                            onCheckedChange = { viewModel.toggleTaskCompletion(item) }
                        )
                        Text(
                            text = item.content ?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            textDecoration = if (item.isCompleted) TextDecoration.LineThrough else null,
                            color = if (item.isCompleted) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                ItemType.LOCATION -> {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Place, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item.content ?: "Pinned Location",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        if (item.locationLat != null && item.locationLng != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            val context = androidx.compose.ui.platform.LocalContext.current
                            OutlinedButton(
                                onClick = {
                                    val uri = android.net.Uri.parse("geo:${item.locationLat},${item.locationLng}?q=${item.locationLat},${item.locationLng}(Pinned Location)")
                                    val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, uri)
                                    context.startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Open in Maps")
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    }
}
