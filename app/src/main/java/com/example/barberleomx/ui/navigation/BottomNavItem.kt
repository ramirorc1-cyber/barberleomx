package com.example.barberleomx.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Paid
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Barberias : BottomNavItem(
        route = "barber_list",
        title = "Barberías",
        icon = Icons.Default.Home
    )

    object Gastos : BottomNavItem(
        route = "gastos",
        title = "Gastos",
        icon = Icons.Default.Paid
    )

    object Perfil : BottomNavItem(
        route = "perfil",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
