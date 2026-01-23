package com.example.barberleomx.ui.screens.barberdetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DireccionTab(
    barberName: String,
    context: Context
) {
    val barberLocations = listOf(
        BarberLocation(
            name = "Barbería Leo",
            address = "Barber Leo, Av Gabriel Leyva Manzana 005, Alfredo del Mazo, 56577 Ixtapaluca, Méx.",
            mapsUrl = "https://maps.app.goo.gl/v8p2B6LhHA8G5h1X8?g_st=ic"
        ),
        BarberLocation(
            name = "Barbería Blessed",
            address = "Barbería BLESSED “Estilo Fino”, Av. Zacatlán 16, San Lorenzo Tezonco, Iztapalapa, 09790 Ciudad de México, CDMX",
            mapsUrl = "https://maps.app.goo.gl/VPMrMhcrb8HVhvip8?g_st=ic"
        ),
        BarberLocation(
            name = "Barbería Doberman",
            address = "Doberman Barber Shop, Av. 8 113, Ignacio Zaragoza, Venustiano Carranza, 15000 Ciudad de México, CDMX",
            mapsUrl = "https://maps.app.goo.gl/1HpxnzRM7nXiPUKn6?g_st=ic"
        )
    )

    val location = barberLocations.find { it.name == barberName }

    if (location == null) {
        Text("Dirección no disponible")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dirección", color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = location.address,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location.mapsUrl))
            context.startActivity(intent)
        }) {
            Text("Ver en mapa")
        }
    }
}

data class BarberLocation(
    val name: String,
    val address: String,
    val mapsUrl: String
)
