package com.example.testappsunil.presentation.ui.composables

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String)  {

    @Serializable
    object MainScreen : Screen("main_screen")

    @Serializable
    object SplashScreen : Screen("splash_screen")

    @Serializable
    object ProductDetailsScreen : Screen("product_detail_screen")

}