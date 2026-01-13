package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.BarberHomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            BarberHomeScreen(navController)
        }

        // Aquí después agregamos:
        // composable("login") { LoginScreen(navController) }
        // composable("perfil") { PerfilScreen(navController) }
        // composable("feed") { FeedScreen(navController) }
    }
}
