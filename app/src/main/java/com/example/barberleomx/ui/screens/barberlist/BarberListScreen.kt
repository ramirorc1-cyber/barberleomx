package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.navigation.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberListScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            // TU CONTENIDO ACTUAL DE BARBERÍAS
        }
    }


            BarberItem("BarberLeoMX", navController)
            BarberItem("Doberman", navController)
            BarberItem("Blassed", navController)
        }


@Composable
fun BarberItem(
    name: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("barber_detail/$name")
            }
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
