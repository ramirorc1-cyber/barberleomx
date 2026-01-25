package com.example.barberleomx.ui.screens.barberdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R

@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Servicios", "Ubicación")

    Scaffold { padding ->

        Column(modifier = Modifier.fillMaxSize()) {

            // 🔵 PORTADA + AVATAR
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {

                // Portada tipo Facebook
                Image(
                    painter = painterResource(id = R.drawable.barber),
                    contentDescription = "Portada del barbero",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Avatar circular
                Image(
                    painter = painterResource(id = R.drawable.leofoto),
                    contentDescription = "Avatar barbero",
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 55.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Nombre del barbero
            Text(
                text = barberName,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tabs
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            // Contenido
            when (selectedTab) {
                0 -> ServiciosTab(
                    navController = navController,
                    barberName = barberName,
                    padding = padding
                )

                1 -> DireccionTab(
                    barberName = barberName,
                    padding = padding
                )
            }
        }
    }
}
