package com.example.barberleomx.ui.navigation

sealed class Routes(val route: String) {
    object Dashboard : Routes("dashboard")

    object Booking : Routes("booking")
    object Services : Routes("services")
    object Barbers : Routes("barbers")
    object Location : Routes("location")
    object Reviews : Routes("reviews")
    object Settings : Routes("settings")
}
