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
    var showCashDialog by remember { mutableStateOf(false) }
    var showTransferDialog by remember { mutableStateOf(false) }

    // ------------------------
    // DIALOGO EFECTIVO
    // ------------------------
    if (showCashDialog) {
        AlertDialog(
            onDismissRequest = { showCashDialog = false },
            confirmButton = {
                Button(onClick = {
                    showCashDialog = false
                    onBack()
                }) {
                    Text("Aceptar")
                }
            },
            title = { Text("Pago en efectivo") },
            text = {
                Text(
                    "Tu pago se realizará directamente en la barbería.\n\n" +
                            "Presenta esta confirmación al barbero el día de tu cita."
                )
            }
        )
    }

    // ------------------------
    // DIALOGO TRANSFERENCIA
    // ------------------------
    if (showTransferDialog) {
        AlertDialog(
            onDismissRequest = { showTransferDialog = false },
            confirmButton = {
                Button(onClick = {
                    showTransferDialog = false
                    onBack()
                }) {
                    Text("Listo")
                }
            },
            title = { Text("Pago por transferencia") },
            text = {
                Column {
                    Text("Realiza la transferencia con los siguientes datos:\n")
                    Text("Banco: BBVA")
                    Text("Cuenta: 1234 5678 9012 3456")
                    Text("Titular: $barberName")
                    Text("\nEl barbero validará tu pago.")
                }
            }
        )
    }

    // ------------------------
    // UI
    // ------------------------
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Barbería",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = barberName,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Total a pagar",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "$$total MXN",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showCashDialog = true }
                ) {
                    Text("Pagar en efectivo")
                }

                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showTransferDialog = true }
                ) {
                    Text("Pagar por transferencia")
                }
            }
        }
    }
}
