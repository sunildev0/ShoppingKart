package com.example.testappsunil.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testappsunil.presentation.ui.composables.Screen
import com.example.testappsunil.presentation.ui.composables.MainProducts
import com.example.testappsunil.presentation.ui.composables.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
                composable(Screen.SplashScreen.route) {
                    SplashScreen(onSplashStarted = {
                    }, onSplashFinished = {
                        navController.navigate(Screen.MainScreen.route)
                    })
                }
                composable(Screen.MainScreen.route) {
                    MyApp {
                        finish()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(onBackClick: () -> Unit) {
    MainProducts()
}