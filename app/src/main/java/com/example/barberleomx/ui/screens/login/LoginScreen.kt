package com.example.barberleomx.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.barberleomx.R

@Composable
fun LoginScreen(navController: NavController) {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.barber),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.headlineMedium
            )

            // inputs y botón...
        }
         @androidx.compose.runtime.Composable fun() {
             Text(
                 text = "Iniciar sesión",
                 style = MaterialTheme.typography.headlineMedium
             )

             OutlinedTextField(
                 value = user,
                 onValueChange = { user = it },
                 label = { Text("Usuario") },
                 modifier = Modifier.fillMaxWidth()
             )

             OutlinedTextField(
                 value = password,
                 onValueChange = { password = it },
                 label = { Text("Contraseña") },
                 visualTransformation = PasswordVisualTransformation(),
                 modifier = Modifier.fillMaxWidth()
             )

             Button(
                 onClick = {
                     // Login simple (sin backend)
                     navController.navigate("barber_list") {
                         popUpTo("login") { inclusive = true }
                     }
                 },
                 modifier = Modifier.fillMaxWidth()
             ) {
                 Text("Entrar")
             }
         }
    }
}
