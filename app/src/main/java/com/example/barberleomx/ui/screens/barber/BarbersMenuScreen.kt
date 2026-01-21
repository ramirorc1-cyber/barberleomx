package com.example.barberleomx.ui.screens.barber

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

@Composable
fun BarbersMenuScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Selecciona una barbería",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        BarberItem("BarberLeoMX", R.drawable.ic_home) {
            navController.navigate("barber_detail/BarberLeoMX")
        }

        BarberItem("Blassed", R.drawable.ic_services) {
            navController.navigate("barber_detail/Blassed")
        }

        BarberItem("Doberman", R.drawable.ic_profile) {
            navController.navigate("barber_detail/Doberman")
        }
    }
}

@Composable
fun BarberItem(name: String, logo: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = name,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = name, style = MaterialTheme.typography.titleLarge)
        }
    }
}
