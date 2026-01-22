package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberListScreen(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Barberías") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            BarberCard(
                name = "BarberLeoMX",
                description = "Estilo clásico y moderno con atención personalizada.",
                imageRes = R.drawable.leo,
                navController = navController
            )

            BarberCard(
                name = "Doberman",
                description = "Cortes urbanos y barba profesional.",
                imageRes = R.drawable.doberman,
                navController = navController
            )

            BarberCard(
                name = "Blassed",
                description = "Elegancia, precisión y buen ambiente.",
                imageRes = R.drawable.blassed,
                navController = navController
            )
        }
    }
}

@Composable
fun BarberCard(
    name: String,
    description: String,
    imageRes: Int,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("barber_detail/$name")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
