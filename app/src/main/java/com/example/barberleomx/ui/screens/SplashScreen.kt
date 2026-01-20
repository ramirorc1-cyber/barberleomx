package com.example.barberleomx.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navController: NavHostController) {
    Text(text = "Splash Screen")

    // Ejemplo de navegación futura:
    // navController.navigate("login")
}
