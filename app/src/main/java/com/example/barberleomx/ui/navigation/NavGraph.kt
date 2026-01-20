package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.splash.SplashScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.home.HomeScreen   // 👈 IMPORT CLAVE
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.detail.BarberDetailScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable(
            route = "detail/{barberId}",
            arguments = listOf(
                navArgument("barberId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val barberId = backStackEntry.arguments?.getInt("barberId") ?: 0
            BarberDetailScreen(navController, barberId)
        }

    }
}
