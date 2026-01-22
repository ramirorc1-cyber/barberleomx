package com.example.barberleomx.ui.screens.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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
