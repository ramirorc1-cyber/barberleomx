package com.example.barberleomx.ui.screens.barberdashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDashboardScreen(
    navController: NavController
) {
    val totalGanado = 2350
    val serviciosRealizados = 14

    val historial = listOf(
        ServicioRealizado("Corte clásico", 150),
        ServicioRealizado("Fade", 180),
        ServicioRealizado("Barba", 120),
        ServicioRealizado("Corte + Barba", 250)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Dashboard del Barbero") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            // ---------- RESUMEN ----------
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Resumen", style = MaterialTheme.typography.titleLarge)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("💰 Total ganado: $${totalGanado}")
                    Text("✂️ Servicios realizados: $serviciosRealizados")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Últimos servicios",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(historial.size) { index ->
                    ServicioItem(historial[index])
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                }
            ) {
                Text("Cerrar sesión")
            }
        }
    }
}

@Composable
private fun ServicioItem(
    servicio: ServicioRealizado
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(servicio.nombre)
            Text("$${servicio.precio}")
        }
    }
}

data class ServicioRealizado(
    val nombre: String,
    val precio: Int
)
