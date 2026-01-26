package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.barberdetail.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen
import com.example.barberleomx.ui.screens.role.RoleSelectionScreen
import com.example.barberleomx.ui.screens.barberdashboard.BarberDashboardScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("role") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("role") {
            RoleSelectionScreen(navController)
        }
        composable("barber_dashboard") {
            BarberDashboardScreen(navController)
        }

        composable("barber_list") {
            BarberListScreen(navController)
        }

        composable("barber_detail/{barberName}") { backStackEntry ->
            BarberDetailScreen(
                barberName = backStackEntry.arguments?.getString("barberName") ?: "",
                navController = navController
            )
        }

        composable("payment/{barberName}/{total}") { backStackEntry ->
            PaymentScreen(
                barberName = backStackEntry.arguments?.getString("barberName") ?: "",
                total = backStackEntry.arguments?.getString("total")?.toInt() ?: 0,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
        // 🔜 Próximo paso
