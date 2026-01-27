package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.barberdetail.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.gastos.GastosScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen
import com.example.barberleomx.ui.screens.role.RoleScreen
import com.example.barberleomx.ui.screens.cita.CitaScreen


@Composable
fun NavGraph(navController: NavHostController, startDestination: String) {

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        // ---------- LOGIN ----------
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.ROLE) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        // ---------- ROL ----------
        composable(Routes.ROLE) {
            RoleScreen(navController)
        }

        // ---------- CLIENTE ----------
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

        // ---------- DETALLE BARBERÍA ----------
        composable("${Routes.BARBER_DETAIL}/{barberName}") { backStackEntry ->
            val barberName =
                backStackEntry.arguments?.getString("barberName") ?: ""

            BarberDetailScreen(
                barberName = barberName,
                navController = navController
            )
        }

        // ---------- PAGO ----------
        composable(Routes.PAYMENT) {
            PaymentScreen(
                navController = navController,
                onBack = { navController.popBackStack() }
            )
        }
        // ---------- CITA ----------
        composable(Routes.CITA) {
            CitaScreen(
                navController = navController
            )
        }


        // ---------- BARBERO ----------
        composable(Routes.GASTOS) {
            GastosScreen(navController)
        }
    }
}

