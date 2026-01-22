package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.screens.barber.BarberService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(
    navController: NavController,
    serviceName: String,
    servicePrice: Int
) {

    var paymentMethod by remember { mutableStateOf("Efectivo") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pago del servicio") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text("Resumen", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            Text("Servicio: $serviceName")
            Text("Precio: $$servicePrice")

            Spacer(Modifier.height(24.dp))

            Text("Método de pago", style = MaterialTheme.typography.titleLarge)

            Row {
                RadioButton(
                    selected = paymentMethod == "Efectivo",
                    onClick = { paymentMethod = "Efectivo" }
                )
                Text("Efectivo", modifier = Modifier.padding(start = 8.dp))
            }

            Row {
                RadioButton(
                    selected = paymentMethod == "Tarjeta",
                    onClick = { paymentMethod = "Tarjeta" }
                )
                Text("Tarjeta", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = {
                    // luego aquí se guarda en SQLite
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar pago")
            }
        }
    }
}
