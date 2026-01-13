package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Dashboard.route
    ) {

        composable(Routes.Dashboard.route) {
            DashboardScreen(navController)
        }

        composable(Routes.Booking.route) {
            BookingScreen()
        }

        composable(Routes.Services.route) {
            ServicesScreen()
        }

        composable(Routes.Barbers.route) {
            BarbersScreen()
        }

        composable(Routes.Location.route) {
            LocationScreen()
        }

        composable(Routes.Reviews.route) {
            ReviewsScreen()
        }

        composable(Routes.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun SettingsScreen() {
    TODO("Not yet implemented")
}

@Composable
fun ReviewsScreen() {
    TODO("Not yet implemented")
}

@Composable
fun LocationScreen() {
    TODO("Not yet implemented")
}

@Composable
fun BarbersScreen() {
    TODO("Not yet implemented")
}

@Composable
fun ServicesScreen() {
    TODO("Not yet implemented")
}

@Composable
fun BookingScreen() {
    TODO("Not yet implemented")
}
