package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen
import com.example.barberleomx.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(navController)
        }
        composable("payment/{total}") {
            PaymentScreen(
                total = it.arguments?.getString("total")?.toInt() ?: 0,
                navController = navController
            )
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
    }
}
