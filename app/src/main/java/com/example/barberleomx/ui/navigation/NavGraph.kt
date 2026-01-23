package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.splash.SplashScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController, startDestination = "splash") {

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

        composable("barber_list") {
            BarberListScreen(navController)
        }
    }
}
