package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.data.local.AppDatabase
import com.example.barberleomx.ui.data.local.entity.Payment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    total: Int,
    navController: NavController
) {
    var selectedMethod by remember { mutableStateOf("Efectivo") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pago") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Total a pagar",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "$$total MXN",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Método de pago",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                PaymentOption(
                    title = "Efectivo",
                    selected = selectedMethod == "Efectivo"
                ) {
                    selectedMethod = "Efectivo"
                }

                PaymentOption(
                    title = "Tarjeta",
                    selected = selectedMethod == "Tarjeta"
                ) {
                    selectedMethod = "Tarjeta"
                }
            }

            val context = LocalContext.current

            Button(
                onClick = {
                    val db = AppDatabase.getDatabase(context)

                    LaunchedEffect(key1 = Unit) {
                        db.paymentDao().insert(
                            Payment(
                                barberName = "BarberLeoMX",
                                total = total,
                                method = selectedMethod
                            )
                        )

                        navController.navigate("barber_list") {
                            popUpTo("barber_list") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar pago")
            }

        }
    }
}

@Composable
fun PaymentOption(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            else
                MaterialTheme.colorScheme.surface
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            RadioButton(selected = selected, onClick = onClick)
        }
    }
}
