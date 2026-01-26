package com.example.barberleomx.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class ClientHistory(
    val barberia: String,
    val servicio: String,
    val fecha: String,
    val total: Int,
    val estado: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientHistoryScreen(
    navController: NavController
) {
    val history = listOf(
        ClientHistory("Barbería Leo", "Corte clásico", "10/06/2026 - 5:00 PM", 150, "Completado"),
        ClientHistory("Barbería Blessed", "Fade", "12/06/2026 - 6:30 PM", 180, "Completado"),
        ClientHistory("Doberman Barber", "Corte + Barba", "15/06/2026 - 4:00 PM", 250, "Pendiente")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Historial de citas") }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(history.size) { index ->
                val item = history[index]

                Card {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(item.barberia, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Servicio: ${item.servicio}")
                        Text("Fecha: ${item.fecha}")
                        Text("Total: $${item.total}")
                        Text(
                            text = item.estado,
                            color =
                                if (item.estado == "Completado")
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}
