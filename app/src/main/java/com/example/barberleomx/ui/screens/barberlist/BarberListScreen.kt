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
                imageRes = R.drawable.leo,
                navController = navController
            )

            BarberCard(
                name = "Doberman",
                imageRes = R.drawable.doberman,
                navController = navController
            )

            BarberCard(
                name = "Blassed",
                imageRes = R.drawable.blessed,
                navController = navController
            )
        }
    }
}

@Composable
fun BarberCard(
    name: String,
    imageRes: Int,
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            Image(
                painter = painterResource(imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(64.dp)
            )

            Spacer(Modifier.width(16.dp))

            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Ver detalles de la barbería",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
