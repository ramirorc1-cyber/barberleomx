package com.example.barberleomx.ui.screens.home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.barberleomx.R

@Composable
fun HomeBottomBar(navController: NavController) {
    NavigationBar {

        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Inicio"
                )
            },
            label = { Text("Inicio") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("services") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_services),
                    contentDescription = "Servicios"
                )
            },
            label = { Text("Servicios") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /* Perfil luego */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") }
        )
    }
}
