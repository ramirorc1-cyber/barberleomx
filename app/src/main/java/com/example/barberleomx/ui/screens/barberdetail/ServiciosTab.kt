package com.example.barberleomx.ui.screens.barberdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.navigation.Routes

@Composable
fun ServiciosTab(
    navController: NavController,
    barberName: String,
    padding: Dp
) {
    val services = listOf(
        Service("Corte clásico", 150),
        Service("Fade", 180),
        Service("Barba", 120),
        Service("Corte + Barba", 250)
    )

    var total by remember { mutableIntStateOf(0) }
    var cantidad by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.padding(padding),
        bottomBar = {
            Surface(shadowElevation = 8.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Servicios: $cantidad",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Total: $${total}",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Button(
                        enabled = total > 0,
                        onClick = {
                            // ✅ NAVEGACIÓN SEGURA (SIN CRASH)
                            navController.navigate(Routes.PAYMENT)
                        }
                    ) {
                        Text("Continuar")
                    }
                }
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(
                text = "Servicios disponibles",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(services.size) { index ->
                    val service = services[index]

                    ServiceItem(
                        service = service,
                        onAdd = {
                            total += service.price
                            cantidad++
                        },
                        onRemove = {
                            if (total >= service.price && cantidad > 0) {
                                total -= service.price
                                cantidad--
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ServiceItem(
    service: Service,
    onAdd: () -> Unit,
    onRemove: () -> Unit
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

            Row {
                OutlinedButton(onClick = onRemove) {
                    Text("−")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = onAdd) {
                    Text("+")
                }
            }
        }
    }
}

data class Service(
    val name: String,
    val price: Int
)
