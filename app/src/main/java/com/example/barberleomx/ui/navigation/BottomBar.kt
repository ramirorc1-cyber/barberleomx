package com.example.barberleomx.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("home") {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("services") {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Filled.Build, contentDescription = "Servicios") },
            label = { Text("Servicios") }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate("profile") {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
