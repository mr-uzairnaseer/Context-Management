package com.itechon.context.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itechon.context.ui.ContextViewModel
import kotlinx.datetime.*
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsightsScreen(
    navController: NavController,
    viewModel: ContextViewModel
) {
    val items by viewModel.allItems.collectAsState()
    val contexts by viewModel.contexts.collectAsState()

    // Calculate Stats
    val totalContexts = contexts.size
    val totalItems = items.size
    val totalTasks = items.count { it.type == com.itechon.context.data.model.ItemType.TASK }
    val completedTasks = items.count { it.type == com.itechon.context.data.model.ItemType.TASK && it.isCompleted }
    val completionRate = if (totalTasks > 0) (completedTasks.toFloat() / totalTasks) * 100 else 0f

    // Weekly Activity
    val today = Clock.System.now()
    val last7Days = (0..6).map { i ->
        today.minus(i, DateTimeUnit.DAY, TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault()).date
    }.reversed()
    
    val activityData = remember(items) {
        last7Days.map { date ->
            val count = items.count { 
                it.timestamp.toLocalDateTime(TimeZone.currentSystemDefault()).date == date 
            }
            date to count
        }
    }
    
    val maxActivity = activityData.maxOfOrNull { it.second } ?: 1

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productivity Insights") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Summary Cards
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "Contexts",
                        value = totalContexts.toString(),
                        icon = Icons.Default.Description,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "Context Items",
                        value = totalItems.toString(),
                        icon = Icons.Default.BarChart, // Placeholder
                        color = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
            }
            
            item {
                StatCard(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Task Completion",
                    value = "${completedTasks}/${totalTasks} (${completionRate.toInt()}%)",
                    icon = Icons.Default.CheckCircle,
                    color = MaterialTheme.colorScheme.tertiaryContainer
                )
            }

            // Activity Chart
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha=0.5f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Activity (Last 7 Days)", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Simple Bar Chart
                        Box(modifier = Modifier.fillMaxSize().padding(bottom = 24.dp)) { // Padding for labels
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val barWidth = size.width / (activityData.size * 2f)
                                val spacing = size.width / activityData.size
                                val maxBarHeight = size.height
                                
                                activityData.forEachIndexed { index, (date, count) ->
                                    val barHeight = (count.toFloat() / maxActivity.toFloat()) * maxBarHeight
                                    val left = index * spacing + (spacing - barWidth) / 2
                                    val top = maxBarHeight - barHeight
                                    
                                    val color = Color(0xFF00E676) // Custom green or use theme color
                                    
                                    drawRect(
                                        color = color,
                                        topLeft = Offset(left, top),
                                        size = Size(barWidth, barHeight)
                                    )
                                }
                            }
                            
                            // Labels (Rough positioning)
                            Row(
                                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).offset(y=24.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                activityData.forEach { (date, _) ->
                                    Text(
                                        text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()).take(1),
                                        style = MaterialTheme.typography.labelSmall,
                                        modifier = Modifier.width(20.dp),
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
            Text(title, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
