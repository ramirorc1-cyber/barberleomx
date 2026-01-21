package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {

    if (barberName != "BarberLeoMX") {
        BarberDisabledScreen(navController)
        return
    }

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(barberName) }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.leo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(Modifier.height(16.dp))

            Text("Acerca de la barbería", style = MaterialTheme.typography.titleLarge)
            Text("Especialistas en estilo, precisión y atención personalizada.")

            Spacer(Modifier.height(16.dp))

            Text("Barbero", style = MaterialTheme.typography.titleLarge)
            Text("👤 Leo Ramírez")
            Text("📞 55 1234 5678")
            Text("📷 Instagram: @barberleomx")

            Spacer(Modifier.height(16.dp))

            Text("Cortes", style = MaterialTheme.typography.titleLarge)

            HaircutItem("Corte clásico", "$150") { showDialog = true }
            HaircutItem("Fade", "$180") { showDialog = true }
            HaircutItem("Barba", "$100") { showDialog = true }

            Spacer(Modifier.height(16.dp))

            Text("Formas de pago", style = MaterialTheme.typography.titleLarge)
            Text("💳 Tarjeta")
            Text("💵 Efectivo en barbería")
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

    if (showDialog) {
        HaircutDialog { showDialog = false }
    }
}

@Composable
fun HaircutDialog(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun BarberDisabledScreen(x0: NavController) {
    TODO("Not yet implemented")
}

@Composable
fun HaircutItem(
    name: String,
    price: String,
    function: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(name)
            Text(price)
        }
    }
}
