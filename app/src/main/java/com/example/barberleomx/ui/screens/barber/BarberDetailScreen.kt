package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.data.local.entity.ServicePaymentEntity
import com.example.barberleomx.ui.data.local.AppDatabase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val db = remember { AppDatabase.getDatabase(context) }

    var paymentMethod by remember { mutableStateOf("Efectivo") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(barberName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(
                    when (barberName) {
                        "BarberLeoMX" -> R.drawable.leo
                        "Doberman" -> R.drawable.doberman
                        else -> R.drawable.blassed
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(Modifier.height(16.dp))

            Text("Servicio", style = MaterialTheme.typography.titleLarge)
            Text("Corte clásico - $150")

            Spacer(Modifier.height(16.dp))

            Text("Forma de pago", style = MaterialTheme.typography.titleMedium)

            Row {
                RadioButton(
                    selected = paymentMethod == "Efectivo",
                    onClick = { paymentMethod = "Efectivo" }
                )
                Text("Efectivo")
            }

            Row {
                RadioButton(
                    selected = paymentMethod == "Tarjeta",
                    onClick = { paymentMethod = "Tarjeta" }
                )
                Text("Tarjeta")
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    scope.launch {
                        db.paymentDao().insertPayment(
                            ServicePaymentEntity(
                                barberName = barberName,
                                serviceName = "Corte clásico",
                                price = 150,
                                paymentMethod = paymentMethod,
                                date = System.currentTimeMillis()
                            )
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar pago")
            }
        }
    }
}
