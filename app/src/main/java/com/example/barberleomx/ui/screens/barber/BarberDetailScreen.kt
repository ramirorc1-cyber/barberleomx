package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.components.HaircutBottomSheet
import com.example.barberleomx.ui.model.Haircut

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {

    var showHaircutSheet by remember { mutableStateOf(false) }
    var selectedHaircut by remember { mutableStateOf<Haircut?>(null) }

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
                .padding(24.dp)
        ) {

            Text(
                text = "Acerca de $barberName",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Barbería comprometida con la calidad, estilo y atención personalizada."
            )

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = { showHaircutSheet = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Elegir tipo de corte")
            }

            selectedHaircut?.let {
                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Corte seleccionado:",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                Text("${it.name} - ${it.price}")
            }

            Spacer(Modifier.height(32.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }

    // 🔽 Bottom Sheet
    if (showHaircutSheet) {
        HaircutBottomSheet(
            onDismiss = { showHaircutSheet = false },
            onConfirm = { haircut ->
                selectedHaircut = haircut
                showHaircutSheet = false
            }
        )
    }
}
