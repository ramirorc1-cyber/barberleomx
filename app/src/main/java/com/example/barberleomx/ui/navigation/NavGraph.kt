package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen

@Composable
fun NavGraph(navController1: NavHostController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "barber_list"
    ) {

        // 🔹 Lista de barberías
        composable("barber_list") {
            BarberListScreen(navController = navController)
        }

        // 🔹 Detalle del barbero
        composable(
            route = "barber_detail/{barberName}",
            arguments = listOf(
                navArgument("barberName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val barberName = backStackEntry.arguments?.getString("barberName") ?: ""

            BarberDetailScreen(
                barberName = barberName,
                onBack = { navController.popBackStack() }
            )
        }

        // 🔹 Pago
        composable(
            route = "payment/{barberName}/{total}",
            arguments = listOf(
                navArgument("barberName") { type = NavType.StringType },
                navArgument("total") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val barberName = backStackEntry.arguments?.getString("barberName") ?: ""
            val total = backStackEntry.arguments?.getFloat("total")?.toDouble() ?: 0.0

            PaymentScreen(
                barberName = barberName,
                total = total,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
