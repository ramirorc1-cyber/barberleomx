package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.barberleomx.ui.screens.login.LoginScreen
import com.example.barberleomx.ui.screens.barberlist.BarberListScreen
import com.example.barberleomx.ui.screens.barber.BarberDetailScreen
import com.example.barberleomx.ui.screens.splash.SplashScreen
import com.example.barberleomx.ui.data.preference.PreferencesManager

@Composable
fun NavGraph(navController: NavHostController) {

    val context = LocalContext.current
    val prefs = PreferencesManager(context)

    val start = if (prefs.isLoggedIn()) "barber_list" else "splash"

    NavHost(
        navController = navController,
        startDestination = start
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
    }
}
