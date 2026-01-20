package com.example.barberleomx.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val barbers = listOf(
        Barber(1, "Barber Leo", "Corte clásico y fade"),
        Barber(2, "Fade Master", "Especialista en fades"),
        Barber(3, "The Barbershop", "Cortes premium")
    )

    Scaffold(
        bottomBar = {
            HomeBottomBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                "Barberías cerca de ti",
                style = MaterialTheme.typography.headlineSmall
            )


            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(barbers) { barber ->
                    BarberCard(
                        barber = barber,
                        onClick = {
                            navController.navigate("detail/${barber.id}")
                        }
                    )

                }
            }
        }
    }
}
