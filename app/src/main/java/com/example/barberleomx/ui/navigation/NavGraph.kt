package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.splash.SplashScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen

@Composable
fun NavGraph(navController: NavHostController, startDestination: String) {

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

        composable("barber_list") {
            BarberListScreen(navController)
        }

        composable("barber_detail/{name}") {
            BarberDetailScreen(
                barberName = it.arguments?.getString("name") ?: "",
                navController = navController
            )
        }

        composable("payment/{name}/{total}") {
            PaymentScreen(
                barberName = it.arguments?.getString("name") ?: "",
                total = it.arguments?.getString("total")?.toDouble() ?: 0.0,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
