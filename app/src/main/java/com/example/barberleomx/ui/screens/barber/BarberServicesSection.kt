package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class BarberService(
    val name: String,
    val price: Int
)

@Composable
fun BarberServicesSection(
    onServiceSelected: (BarberService) -> Unit
) {

    val services = listOf(
        BarberService("Corte clásico", 150),
        BarberService("Corte + barba", 220),
        BarberService("Barba", 100),
        BarberService("Diseño", 80)
    )

    Column {
        Text(
            text = "Servicios",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(8.dp))

        services.forEach { service ->
            ServiceItem(
                service = service,
                onClick = { onServiceSelected(service) }
            )
        }
    }
}

@Composable
private fun ServiceItem(
    service: BarberService,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(service.name)
            Text("$${service.price}")
        }
    }
}
