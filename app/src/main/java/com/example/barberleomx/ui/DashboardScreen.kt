package com.example.barberleomx.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.components.CircleMenuButton

@Composable
fun DashboardScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleMenuButton(
                icon = Icons.Default.Event,
                text = "Reservar cita",
                backgroundColor = Color(0xFF1E88E5)
            ) { }

            CircleMenuButton(
                icon = Icons.Default.Build,
                text = "Servicios",
                backgroundColor = Color.DarkGray
            ) { }

            CircleMenuButton(
                icon = Icons.Default.Person,
                text = "Barberos",
                backgroundColor = Color(0xFFB87333)
            ) { }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleMenuButton(
                icon = Icons.Default.LocationOn,
                text = "Ubicación",
                backgroundColor = Color(0xFF2E7D32)
            ) { }

            CircleMenuButton(
                icon = Icons.Default.Star,
                text = "Reseñas",
                backgroundColor = Color(0xFF8D3C2F)
            ) { }

            CircleMenuButton(
                icon = Icons.Default.Settings,
                text = "Ajustes",
                backgroundColor = Color.Black
            ) { }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(
        navController = rememberNavController()
    )
}
