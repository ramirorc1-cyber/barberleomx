package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    barberName: String,
    total: Int,
    onBack: () -> Unit
) {
    var metodoPago by remember { mutableStateOf<MetodoPago?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pago") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // ----------------------------
            // INFO BARBERO
            // ----------------------------
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Barbería",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = barberName,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            // ----------------------------
            // TOTAL
            // ----------------------------
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Total a pagar",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = "$$total MXN",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            // ----------------------------
            // MÉTODO DE PAGO
            // ----------------------------
            Text(
                text = "Selecciona método de pago",
                style = MaterialTheme.typography.titleMedium
            )

            MetodoPagoItem(
                titulo = "Efectivo",
                seleccionado = metodoPago == MetodoPago.EFECTIVO,
                onClick = { metodoPago = MetodoPago.EFECTIVO }
            )

            MetodoPagoItem(
                titulo = "Tarjeta",
                seleccionado = metodoPago == MetodoPago.TARJETA,
                onClick = { metodoPago = MetodoPago.TARJETA }
            )

            Spacer(modifier = Modifier.weight(1f))

            // ----------------------------
            // BOTÓN CONFIRMAR
            // ----------------------------
            Button(
                onClick = {
                    // Aquí después puedes meter BD o lógica real
                },
                enabled = metodoPago != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Confirmar pago")
            }
        }
    }
}

// ----------------------------
// ITEM MÉTODO DE PAGO
// ----------------------------
@Composable
private fun MetodoPagoItem(
    titulo: String,
    seleccionado: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = if (seleccionado)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = seleccionado,
                onClick = onClick
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = titulo,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// ----------------------------
// ENUM MÉTODOS
// ----------------------------
private enum class MetodoPago {
    EFECTIVO,
    TARJETA
}
