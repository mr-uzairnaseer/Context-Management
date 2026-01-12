package com.itechon.context.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.data.model.ItemType

@Composable
fun ItemRow(item: ItemEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = when (item.type) {
                        ItemType.NOTE -> Icons.Default.Description
                        ItemType.PHOTO -> Icons.Default.Image
                        ItemType.AUDIO -> Icons.Default.Mic
                        ItemType.LOCATION -> Icons.Default.Description // Placeholder
                    },
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.timestamp.toString(), // Needs better formatting
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
                    if (item.mediaUri != null) {
                        AsyncImage(
                            model = item.mediaUri,
                            contentDescription = "Captured Photo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }
                }
                ItemType.AUDIO -> {
                    Text("Voice Note (Playable UI here)")
                }
                else -> {}
            }
        }
    }
}
