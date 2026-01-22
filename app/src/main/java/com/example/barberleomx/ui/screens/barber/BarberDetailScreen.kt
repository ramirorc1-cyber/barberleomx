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
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {

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
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Acerca de la barbería",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Barbería comprometida con la calidad, el estilo y una excelente atención al cliente."
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* siguiente sprint: servicios */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver servicios")
            }
        }
    }
}
