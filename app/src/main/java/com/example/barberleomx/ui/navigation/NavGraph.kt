package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.barberdetail.BarberDetailScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen
import com.example.barberleomx.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = "splash"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // ---------------- SPLASH ----------------
        composable("splash") {
            SplashScreen(navController as NavController)
        }

        // ---------------- LOGIN ----------------
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("barber_list") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        // ---------------- LISTA BARBERÍAS ----------------
        composable("barber_list") {
            BarberListScreen(navController)
        }

        // ---------------- DETALLE BARBERÍA ----------------
        composable("barber_detail/{barberName}") { backStackEntry ->
            BarberDetailScreen(
                barberName = backStackEntry.arguments?.getString("barberName") ?: "",
                navController = navController
            )
        }

        // ---------------- PAGO ----------------
        composable("payment/{barberName}/{total}") { backStackEntry ->
            PaymentScreen(
                barberName = backStackEntry.arguments?.getString("barberName") ?: "",
                total = backStackEntry.arguments?.getString("total")?.toInt() ?: 0,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
