package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    navController: NavController,
    onBack: () -> Unit
) {
    // 🔑 LEEMOS EL TOTAL CORRECTAMENTE
    val total = navController
        .currentBackStackEntry
        ?.savedStateHandle
        ?.get<Int>("total") ?: 0

    var showCashDialog by remember { mutableStateOf(false) }

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
            text = { Text("Paga directamente en la barbería.") }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pago") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
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
                Text("Total a pagar")
                Text(
                    text = "$$total MXN",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showCashDialog = true }
            ) {
                Text("Pagar en efectivo")
            }
        }
    }
}
