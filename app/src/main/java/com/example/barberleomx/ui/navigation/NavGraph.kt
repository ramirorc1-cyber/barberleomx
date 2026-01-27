package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.barberdetail.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.history.ClientHistoryScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.BARBER_LIST) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.BARBER_LIST) {
            BarberListScreen(
                navController = navController,
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.BARBER_LIST) { inclusive = true }
                    }
                }
            )
        }

        composable("history") {
            ClientHistoryScreen(navController)
        }

        composable("${Routes.BARBER_DETAIL}/{barberName}") { backStackEntry ->
            BarberDetailScreen(
                barberName = backStackEntry.arguments?.getString("barberName") ?: "",
                navController = navController
            )
        }

        // ✅ PAGO SIN PARÁMETROS (NO CRASHEA)
        composable(Routes.PAYMENT) {
            PaymentScreen(
                barberName = "",
                total = 0,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
