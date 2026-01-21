package com.example.barberleomx.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.barberleomx.R

@Composable
fun ServicesSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ServiceCard("Shaving", R.drawable.ic_services)
        ServiceCard("Haircut", R.drawable.ic_services)
        ServiceCard("Styling", R.drawable.ic_services)
    }
}

@Composable
fun ServiceCard(title: String, icon: Int) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC107)),
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = title
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title)
        }
    }
}
