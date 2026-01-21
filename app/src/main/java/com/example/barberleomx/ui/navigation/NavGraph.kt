package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.barberleomx.ui.screens.barberdetail.BarberDetailScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {


    NavHost(
        navController = navController,
        startDestination = startDestination
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

        composable(
            "barber_detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            BarberDetailScreen(
                navController,
                it.arguments?.getString("name") ?: ""
            )
        }
    }}
