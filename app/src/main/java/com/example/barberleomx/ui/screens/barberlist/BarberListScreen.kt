package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BarberListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Barberías",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("barber_detail/Barbería Leo")
                }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Barbería Leo", style = MaterialTheme.typography.titleMedium)
                Text("Cortes clásicos y modernos")
            }
        }
    }
}
