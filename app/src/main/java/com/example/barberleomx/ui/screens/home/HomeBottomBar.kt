package com.example.barberleomx.ui.screens.home

import androidx.compose.material3.*
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
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("services") },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_services),
                    contentDescription = "Services"
                )
            },
            label = { Text("Services") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("login") },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile"
                )
            },
            label = { Text("Profile") }
        )
    }
}
