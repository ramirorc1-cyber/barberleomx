package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    barberName: String,
    total: Double,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Pago",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Barbería: $barberName")
            Text("Total: $${total}")

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { /* efectivo */ }) {
                Text("Pagar en efectivo")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { /* tarjeta */ }) {
                Text("Pagar con tarjeta")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onBack) {
                Text("Cancelar")
            }
        }
    }
}
