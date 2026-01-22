package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.barberleomx.ui.screens.splash.SplashScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.payment.PaymentScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Routes.SPLASH) {
            SplashScreen(navController)
        }

        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        composable(Routes.BARBER_LIST) {
            BarberListScreen(navController)
        }
        composable(
            route = "payment/{name}/{price}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("price") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val name = backStackEntry.arguments?.getString("name") ?: ""
            val price = backStackEntry.arguments?.getInt("price") ?: 0

            PaymentScreen(
                navController = navController,
                serviceName = name,
                servicePrice = price
            )
        }

        composable(
            route = "${Routes.BARBER_DETAIL}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            BarberDetailScreen(
                navController = navController,
                barberName = it.arguments?.getString("name") ?: ""
            )
        }
    }
}
