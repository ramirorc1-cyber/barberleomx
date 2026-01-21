package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.ui.session.SessionManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {

    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

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
                .fillMaxSize()
        ) {

            // 🔹 Imagen de barbería
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
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            // 🔹 Acerca de
            Text(
                text = "Acerca de la barbería",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Especialistas en estilo, precisión y atención personalizada."
            )

            Spacer(Modifier.height(24.dp))

            // 🔹 Cortes
            Text(
                text = "Cortes disponibles",
                style = MaterialTheme.typography.titleLarge
            )

            HaircutItem("Corte clásico", "$150")
            HaircutItem("Fade", "$180")
            HaircutItem("Barba", "$100")

            Spacer(Modifier.height(24.dp))

            // 🔹 Formas de pago
            Text(
                text = "Formas de pago",
                style = MaterialTheme.typography.titleLarge
            )
            Text("💳 Tarjeta")
            Text("💵 Efectivo")
            Text("📲 Transferencia")

            Spacer(Modifier.height(32.dp))

            // 🔹 Botón cerrar sesión
            Button(
                onClick = {
                    sessionManager.logout()
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Cerrar sesión")
            }

            Spacer(Modifier.height(12.dp))

            // 🔹 Volver
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}

@Composable
fun HaircutItem(
    name: String,
    price: String
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
