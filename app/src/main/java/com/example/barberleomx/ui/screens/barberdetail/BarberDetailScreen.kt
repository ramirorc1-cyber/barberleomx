package com.example.barberleomx.ui.screens.barberdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    navController: NavController,
    barberName: String
) {
    val tabs = listOf("Servicios", "Dirección")
    var selectedTab by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(barberName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            when (selectedTab) {
                0 -> ServiciosTab(
                    navController = navController,
                    barberName = barberName,
                    padding = PaddingValues(0.dp)
                )

                1 -> DireccionTab(
                    barberName = barberName,
                    context = context
                )
            }
        }
    }
}
