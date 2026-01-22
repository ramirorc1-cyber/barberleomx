package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.home.HomeScreen
import com.example.barberleomx.ui.screens.perfil.PerfilScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("services") {
            ServicesScreen()
        }

        composable("profile") {
            PerfilScreen(navController)
        }

        composable("barber_list") {
            BarberListScreen(navController)
        }

        composable(
            "barber_detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            BarberDetailScreen(
                navController = navController,
                barberName = it.arguments?.getString("name") ?: ""
            )
        }
    }

}
