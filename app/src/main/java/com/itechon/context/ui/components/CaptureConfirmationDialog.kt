package com.itechon.context.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity

@Composable
fun CaptureConfirmationDialog(
    item: ItemEntity,
    suggestions: List<ContextEntity>,
    onConfirm: (String) -> Unit,
    onCancel: () -> Unit,
    onNewContext: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancel,
        title = { Text("Assign to Context") },
        text = {
            Column {
                Text("We suggests these contexts based on your situation:")
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(modifier = Modifier.heightIn(max = 200.dp)) {
                    items(suggestions) { context ->
                        ListItem(
                            headlineContent = { Text(context.title) },
                            modifier = Modifier.clickable { onConfirm(context.id) }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(onClick = onNewContext) {
                    Text("+ Create New Context")
                }
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text("Cancel")
            }
        }
    )
}
