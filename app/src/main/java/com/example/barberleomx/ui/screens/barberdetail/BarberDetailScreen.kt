package com.example.barberleomx.ui.screens.barberdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {
    // ---- cortes fake (SIN BD) ----
    val services = listOf(
        Service("Corte clásico", 150),
        Service("Fade", 180),
        Service("Barba", 120),
        Service("Corte + Barba", 250)
    )

    var total by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(barberName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total: $${total}",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Button(
                        enabled = total > 0,
                        onClick = {
                            navController.navigate("payment/$barberName/$total")
                        }
                    ) {
                        Text("Continuar")
                    }
                }
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Text(
                    text = "Servicios disponibles",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            items(services.size) { index ->
                val service = services[index]

                ServiceItem(
                    service = service,
                    onAdd = {
                        total += service.price
                    }
                )
            }
        }
    }
}

@Composable
private fun ServiceItem(
    service: Service,
    onAdd: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = service.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "$${service.price}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Button(onClick = onAdd) {
                Text("Agregar")
            }
        }
    }
}

// ---- modelo simple (SIN BD) ----
private data class Service(
    val name: String,
    val price: Int
)
