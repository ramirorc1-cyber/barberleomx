package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.booking.BookingScreen
import com.example.barberleomx.ui.screens.detail.BarberDetailScreen
import com.example.barberleomx.ui.screens.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("services") {
            ServicesScreen()
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

        composable(
            route = "booking/{barberId}",
            arguments = listOf(
                navArgument("barberId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val barberId = backStackEntry.arguments?.getInt("barberId") ?: 0
            BookingScreen(navController, barberId)
        }
    }
}
