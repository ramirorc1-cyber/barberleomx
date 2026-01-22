package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.barberleomx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavHostController
) {

    var showProfile by remember { mutableStateOf(false) }

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

            Text(
                text = "Acerca de la barbería",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Especialistas en estilo, precisión y atención personalizada."
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { showProfile = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver perfil del barbero")
            }
        }
    }

    if (showProfile) {
        BarberProfileDialog(
            onDismiss = { showProfile = false }
        )
    }
}
