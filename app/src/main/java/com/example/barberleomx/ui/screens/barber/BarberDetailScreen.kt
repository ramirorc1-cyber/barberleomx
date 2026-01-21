package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(navController: NavController, barberName: String) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(barberName) })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
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

            Text("Acerca de la barbería", style = MaterialTheme.typography.titleLarge)
            Text("Especialistas en estilo, precisión y atención personalizada.")

            Spacer(Modifier.height(16.dp))

            Text("Cortes", style = MaterialTheme.typography.titleLarge)

            HaircutItem("Corte clásico", "$150")
            HaircutItem("Fade", "$180")
            HaircutItem("Barba", "$100")

            Spacer(Modifier.height(16.dp))

            Text("Formas de pago", style = MaterialTheme.typography.titleLarge)
            Text("💳 Tarjeta")
            Text("💵 Efectivo")
            Text("📲 Transferencia")

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}

@Composable
fun HaircutItem(name: String, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(name)
            Text(price)
        }
    }
}
