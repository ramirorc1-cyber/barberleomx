package com.example.barberleomx.ui.screens.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navController: NavHostController) {
    Text(text = "Splash Screen")

    // Luego puedes hacer:
    // LaunchedEffect(Unit) { navController.navigate("login") }
}
