package com.example.barberleomx.ui.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place   // 👈 ESTE ES EL CORRECTO (para "Mapa")
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeBottomBar(navController: NavController) {
    NavigationBar {

        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /* luego mapa */ },
            icon = { Icon(Icons.Default.Place, contentDescription = "Mapa") }, // 👈 CAMBIO AQUÍ
            label = { Text("Mapa") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /* luego perfil */ },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
