package com.example.barberleomx.ui.screens.cita

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitaScreen(navController: NavController) {

    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }

    val formValido = fecha.isNotBlank() && hora.isNotBlank()

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.65f))
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Agendar cita", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    )
                )
            }
        ) { padding ->

            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Selecciona fecha y hora",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(Modifier.height(24.dp))

                    OutlinedTextField(
                        value = fecha,
                        onValueChange = { fecha = it },
                        label = { Text("Fecha (DD/MM/AAAA)") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors()
                    )

                    Spacer(Modifier.height(16.dp))

                    OutlinedTextField(
                        value = hora,
                        onValueChange = { hora = it },
                        label = { Text("Hora (Ej. 16:30)") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors()
                    )
                }

                Button(
                    enabled = formValido,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.currentBackStackEntry
                            ?.savedStateHandle
                            ?.set("fecha", fecha)

                        navController.currentBackStackEntry
                            ?.savedStateHandle
                            ?.set("hora", hora)

                        navController.navigate(Routes.PAYMENT)
                    }
                ) {
                    Text("Continuar al pago")
                }
            }
        }
    }
}

@Composable
private fun textFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = Color.Gray,
        focusedLabelColor = Color.White,
        unfocusedLabelColor = Color.LightGray,
        cursorColor = Color.White
    )
