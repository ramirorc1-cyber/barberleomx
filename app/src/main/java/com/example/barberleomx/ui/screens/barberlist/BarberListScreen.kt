package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun BarberListScreen(
    navController: NavController
) {
    val barbers = listOf(
        Barber("Barbería Leo", R.drawable.leo),
        Barber("Barbería Blessed", R.drawable.blessed),
        Barber("Barbería Doberman", R.drawable.doberman)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Barberías") }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(barbers) { barber ->
                BarberCard(
                    barber = barber,
                    onClick = {
                        navController.navigate("barber_detail/${barber.name}")
                    }
                )
            }
        }
    }
}

@Composable
private fun BarberCard(
    barber: Barber,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = barber.logo),
                contentDescription = barber.name,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = barber.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

private data class Barber(
    val name: String,
    val logo: Int
)

