package com.example.barberleomx.ui.screens.barberdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(barberName) })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
        ) {
            Text(
                text = "Acerca de $barberName",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Barbería comprometida con la calidad, estilo y atención personalizada."
            )

            Spacer(Modifier.height(32.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }
    }
}
