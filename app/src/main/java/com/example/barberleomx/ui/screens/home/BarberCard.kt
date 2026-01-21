package com.example.barberleomx.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BarbersSection(navController: NavController) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        BarberItem("Jeremy Stevens", navController, 1)
        BarberItem("Aaron Baldwin", navController, 2)
        BarberItem("Matthew Smith", navController, 3)
    }
}

@Composable
fun BarberItem(
    name: String,
    navController: NavController,
    barberId: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(name)
        Button(
            onClick = {
                navController.navigate("detail/$barberId")
            }
        ) {
            Text("BOOK")
        }
    }
}
