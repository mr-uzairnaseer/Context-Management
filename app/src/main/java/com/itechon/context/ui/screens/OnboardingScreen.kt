package com.itechon.context.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itechon.context.ui.ContextViewModel

@Composable
fun OnboardingScreen(navController: NavController, viewModel: ContextViewModel) {
    var currentStep by remember { mutableStateOf(0) }
    
    val steps = listOf(
        OnboardingStep(
            icon = Icons.Default.Bolt,
            title = "Quick Capture",
            description = "Instantly capture thoughts, images, and audio. Everything is stored locally on your device."
        ),
        OnboardingStep(
            icon = Icons.Default.Layers,
            title = "Context Aware",
            description = "Organize your life into Contexts. Link items, add tags, and keep your workspace clutter-free."
        ),
        OnboardingStep(
            icon = Icons.Default.Security,
            title = "Secure & Private",
            description = "Your data is yours. Secure your app with biometrics and export your data anytime."
        )
    )

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            
            // Content
            val step = steps[currentStep]
            Icon(
                imageVector = step.icon,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                    .padding(32.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = step.title,
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = step.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Indicators
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                steps.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(10.dp)
                            .background(
                                if (index == currentStep) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                                CircleShape
                            )
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Button
            Button(
                onClick = {
                    if (currentStep < steps.size - 1) {
                        currentStep++
                    } else {
                        viewModel.completeOnboarding()
                        // Navigate to Home will be handled by MainActivity logic observing the state, 
                        // OR we can explicitly navigate here if we are INSIDE the NavHost.
                        // Since Onboarding will be a route, we navigate to Home.
                        navController.navigate("home") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(if (currentStep < steps.size - 1) "Next" else "Get Started")
                if (currentStep < steps.size - 1) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

data class OnboardingStep(
    val icon: ImageVector,
    val title: String,
    val description: String
)
