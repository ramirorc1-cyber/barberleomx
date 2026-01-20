package com.example.barberleomx.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.*
import com.example.barberleomx.ui.screens.AjustesScreen
import com.example.barberleomx.ui.screens.BarberHomeScreen
import com.example.barberleomx.ui.screens.CitasScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { BarberHomeScreen(navController) }
        composable("citas") { CitasScreen() }
        composable("clientes") { ClientesScreen() }
        composable("ajustes") { AjustesScreen() }
    }
}

@Composable
fun ClientesScreen() {
    TODO("Not yet implemented")
}
