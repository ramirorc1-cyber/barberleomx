package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberListScreen(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Selecciona una barbería") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            BarberItem(
                name = "BarberLeoMX",
                description = "Barbería profesional",
                navController = navController
            )

            BarberItem(
                name = "Blassed",
                description = "Estilo urbano",
                navController = navController
            )

            BarberItem(
                name = "Doberman",
                description = "Cortes clásicos",
                navController = navController
            )
        }
    }
}

@Composable
fun BarberItem(
    name: String,
    description: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("barber_detail/$name")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
