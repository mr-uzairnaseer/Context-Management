package com.itechon.context

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api
import com.itechon.context.ui.ContextViewModel
import com.itechon.context.ui.screens.ContextDetailScreen
import com.itechon.context.ui.screens.HomeScreen
import com.itechon.context.ui.screens.LoginScreen
import com.itechon.context.ui.screens.SearchScreen
import com.itechon.context.ui.theme.ContextTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val app = application as ContextApp
        val viewModelFactory = ContextViewModel.Factory(app.repository, app.itemRepository)

        setContent {
            ContextTheme {
                val navController = rememberNavController()
                val viewModel: ContextViewModel = viewModel(factory = viewModelFactory)

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("home") {
                        HomeScreen(navController, viewModel)
                    }
                    composable("context_detail/{contextId}") { backStackEntry ->
                        val contextId = backStackEntry.arguments?.getString("contextId")
                        if (contextId != null) {
                            ContextDetailScreen(contextId, viewModel, navController)
                        }
                    }
                    composable("search") {
                        SearchScreen(navController, viewModel)
                    }
                }
            }
        }
    }
}