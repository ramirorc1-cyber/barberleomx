package com.example.barberleomx.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barberleomx.R

@Composable
fun SplashScreen(
    onEnterClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // Imagen de fondo (opcional, puedes cambiarla luego)
        Image(
            painter = painterResource(id = R.drawable.barber_background),
            contentDescription = "Fondo barbería",
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4f
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Barber Leo MX",
                color = Color.White,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = onEnterClick,
                shape = CircleShape,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E88E5) // azul
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_barber),
                    contentDescription = "Entrar"
                )
            }
        }
    }
}
