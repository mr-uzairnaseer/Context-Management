package com.itechon.context.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.itechon.context.ui.ContextViewModel

@Composable
fun MainScreen(
    mainNavController: NavController, // For navigation outside main tabs (e.g. details)
    viewModel: ContextViewModel,
    initialShortcut: String? = null
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                NavigationBarItem(
                    icon = { Icon(Icons.Default.ChatBubble, contentDescription = "Contexts") },
                    label = { Text("Contexts") },
                    selected = currentRoute == "contexts",
                    onClick = {
                        bottomNavController.navigate("contexts") {
                            popUpTo(bottomNavController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.tertiary,
                        selectedIconColor = MaterialTheme.colorScheme.onTertiary,
                        selectedTextColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "History") },
                    label = { Text("History") },
                    selected = currentRoute == "history",
                    onClick = {
                        bottomNavController.navigate("history") {
                            popUpTo(bottomNavController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.tertiary,
                        selectedIconColor = MaterialTheme.colorScheme.onTertiary,
                        selectedTextColor = MaterialTheme.colorScheme.onSurface
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = currentRoute == "profile",
                    onClick = {
                        bottomNavController.navigate("profile") {
                            popUpTo(bottomNavController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.tertiary,
                        selectedIconColor = MaterialTheme.colorScheme.onTertiary,
                        selectedTextColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "contexts",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("contexts") {
                HomeScreen(navController = mainNavController, viewModel = viewModel, initialShortcut = initialShortcut)
            }
            composable("history") {
                HistoryScreen(navController = mainNavController, viewModel = viewModel)
            }
            composable("profile") {
                ProfileScreen(navController = mainNavController, viewModel = viewModel)
            }
        }
    }
}
