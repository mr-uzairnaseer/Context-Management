package com.itechon.context

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.compose.material3.ExperimentalMaterial3Api
import com.itechon.context.ui.ContextViewModel
import io.github.jan.supabase.gotrue.handleDeeplinks
import com.itechon.context.data.remote.SupabaseModule
import com.itechon.context.ui.screens.ResetPasswordScreen
import com.itechon.context.ui.screens.ContextDetailScreen
import com.itechon.context.ui.screens.HomeScreen
import com.itechon.context.ui.screens.LoginScreen
import com.itechon.context.ui.screens.HistoryScreen
import com.itechon.context.ui.screens.MainScreen
import com.itechon.context.ui.screens.ImageViewerScreen
import com.itechon.context.ui.theme.ContextTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Handle Deep Links for Auth
        SupabaseModule.client.handleDeeplinks(intent)

        // Handle App Shortcuts when app is already running (via onCreate) - Logic below handles routing.
        val intentData = intent?.data
        var initialShortcutRoute: String? = null
        if (intentData != null && intentData.scheme == "context") {
             if (intentData.host == "new") {
                 initialShortcutRoute = "new_context"
             } else if (intentData.host == "search") {
                 initialShortcutRoute = "search"
             }
        }

        val app = application as ContextApp
        val viewModelFactory = ContextViewModel.Factory(app.repository, app.itemRepository, app.calendarRepository, app.ocrHelper, app.audioHelper, app.locationHelper, app.userPreferencesRepository)


        setContent {
            val viewModel: ContextViewModel = viewModel(factory = viewModelFactory)
            val isDarkTheme by viewModel.isDarkTheme.collectAsState()
            val isBiometricEnabled by viewModel.isBiometricEnabled.collectAsState()

            // Authentication State
            var isAuthenticated by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
            // If biometric is disabled, we are implicitly authenticated (once the flow loads).
            // However, we start false to be safe during load, OR we need to know if flow is loaded.
            // Simplified: If biometric is DISABLED -> authenticated = true.
            // If ENABLED -> authenticated = false initially.
            // We use a side effect to update this logic when flow changes.
            
            androidx.compose.runtime.LaunchedEffect(isBiometricEnabled) {
                if (!isBiometricEnabled) {
                    isAuthenticated = true
                } else if (!isAuthenticated) {
                    // Trigger auth
                    val authHelper = com.itechon.context.utils.AuthenticationHelper(this@MainActivity)
                    if (authHelper.isBiometricAvailable()) {
                        authHelper.authenticate(
                            onSuccess = { isAuthenticated = true },
                            onError = { /* Handle error or close app? */ }
                        )
                    } else {
                        // Fallback if hardware unavailable but pref enabled? Unlock or show error.
                        isAuthenticated = true 
                    }
                }
            }

            ContextTheme(darkTheme = isDarkTheme) {
                // A surface container using the 'background' color from the theme
                androidx.compose.material3.Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = androidx.compose.material3.MaterialTheme.colorScheme.background
                ) {
                    val isOnboardingCompleted by viewModel.isOnboardingCompleted.collectAsState()

                    if (!isAuthenticated && isBiometricEnabled) {
                        // Lock Screen UI
                        androidx.compose.foundation.layout.Box(
                            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                           androidx.compose.material3.Text("Unlock Context to continue")
                           androidx.compose.material3.Button(onClick = {
                               val authHelper = com.itechon.context.utils.AuthenticationHelper(this@MainActivity)
                               authHelper.authenticate(
                                   onSuccess = { isAuthenticated = true },
                                   onError = { }
                               )
                           }, modifier = androidx.compose.ui.Modifier.padding(top = 16.dp)) {
                               androidx.compose.material3.Text("Unlock")
                           }
                        }
                    } else {
                        val navController = rememberNavController()

                    // Check if we launched via deep link
                    val startDest = if (intent?.data?.host == "reset-callback") {
                        android.util.Log.d("DeepLink", "Received: ${intent?.data}")
                        "reset_password"
                    } else if (!isOnboardingCompleted) {
                        "onboarding"
                    } else {
                        "login"
                    }

                    NavHost(navController = navController, startDestination = startDest) {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("signup") {
                            com.itechon.context.ui.screens.SignUpScreen(navController)
                        }
                        composable("forgot_password") {
                            com.itechon.context.ui.screens.ForgotPasswordScreen(navController)
                        }
                        composable("reset_password") {
                            ResetPasswordScreen(navController)
                        }
                        composable("profile") {
                            com.itechon.context.ui.screens.ProfileScreen(navController, viewModel)
                        }
                        composable("edit_profile") {
                            com.itechon.context.ui.screens.EditProfileScreen(navController)
                        }
                        composable(
                            "home?shortcut={shortcut}",
                             arguments = listOf(androidx.navigation.navArgument("shortcut") { nullable = true; defaultValue = null })
                        ) { backStackEntry ->
                            val shortcut = backStackEntry.arguments?.getString("shortcut")
                            MainScreen(mainNavController = navController, viewModel = viewModel, initialShortcut = shortcut)
                        }
                        composable("history") {
                            HistoryScreen(navController = navController, viewModel = viewModel)
                        }
                        composable("context_detail/{contextId}") { backStackEntry ->
                            val contextId = backStackEntry.arguments?.getString("contextId")
                            if (contextId != null) {
                                ContextDetailScreen(contextId, viewModel, navController)
                            }
                        }
                        composable(
                            "image_viewer/{imageUrl}",
                            arguments = listOf(navArgument("imageUrl") { type = androidx.navigation.NavType.StringType })
                        ) { backStackEntry ->
                            val imageUrl = backStackEntry.arguments?.getString("imageUrl")
                            if (imageUrl != null) {
                                // Decode the URL if necessary, though navigation might handle basic encoding if passed correctly.
                                val decodedUrl = java.net.URLDecoder.decode(imageUrl, "UTF-8")
                                ImageViewerScreen(imageUrl = decodedUrl, navController = navController)
                            }
                        }
                        composable("onboarding") {
                            com.itechon.context.ui.screens.OnboardingScreen(navController, viewModel)
                        }
                        composable("insights") {
                            com.itechon.context.ui.screens.InsightsScreen(navController, viewModel)
                        }
                    }
                }
            }
        }
    }
}
}