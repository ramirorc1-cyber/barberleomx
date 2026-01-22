package com.example.barberleomx.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.barberleomx.ui.model.Service

@Composable
fun ServiceItem(
    service: Service,
    onAdd: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onAdd() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = service.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "$${service.price}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Button(onClick = onAdd) {
                Text("Agregar")
            }
        }
    }
}
