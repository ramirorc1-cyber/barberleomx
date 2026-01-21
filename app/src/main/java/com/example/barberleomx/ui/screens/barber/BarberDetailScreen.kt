package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
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
        ) {

            // LOGO DE LA BARBERÍA
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

            // ACERCA DE
            Text(
                text = "Acerca de la barbería",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Especialistas en estilo, precisión y atención personalizada."
            )

            Spacer(Modifier.height(16.dp))

            // CORTES
            Text(
                text = "Cortes",
                style = MaterialTheme.typography.titleLarge
            )

            HaircutItem("Corte clásico", "$150")
            HaircutItem("Fade", "$180")
            HaircutItem("Barba", "$100")

            Spacer(Modifier.height(16.dp))

            // FORMAS DE PAGO
            Text(
                text = "Formas de pago",
                style = MaterialTheme.typography.titleLarge
            )
            Text("💳 Tarjeta")
            Text("💵 Efectivo")
            Text("📲 Transferencia")

            Spacer(Modifier.height(24.dp))

            // BOTÓN VOLVER
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }

            Spacer(Modifier.height(12.dp))

            // BOTÓN CERRAR SESIÓN
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
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(name)
            Text(price)
        }
    }
}
