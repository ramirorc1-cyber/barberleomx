package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.example.barberleomx.ui.data.database.AppDatabase
import com.example.barberleomx.ui.data.entity.CitaEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    navController: NavController,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val db = remember { AppDatabase.getDatabase(context) }
    val scope = rememberCoroutineScope()

    val total =
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<Int>("total") ?: 0

    val fecha =
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<String>("fecha") ?: "No seleccionada"

    val hora =
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<String>("hora") ?: "No seleccionada"

    var showCashDialog by remember { mutableStateOf(false) }

    if (showCashDialog) {
        AlertDialog(
            onDismissRequest = { showCashDialog = false },
            confirmButton = {
                Button(onClick = {
                    showCashDialog = false
                    onBack()
                }) { Text("Aceptar") }
            },
            title = { Text("Pago en efectivo") },
            text = {
                Text("Cita agendada para:\n$fecha a las $hora")
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pago") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, null)
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
                Text("$$total MXN", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Text("Fecha: $fecha")
                Text("Hora: $hora")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    scope.launch {
                        db.citaDao().insertarCita(
                            CitaEntity(
                                barberName = "Barbería seleccionada",
                                total = total,
                                fecha = fecha,
                                hora = hora
                            )
                        )
                    }
                    showCashDialog = true
                }
            ) {
                Text("Pagar en efectivo")
            }
        }
    }
}
