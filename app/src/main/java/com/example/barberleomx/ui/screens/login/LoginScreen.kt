package com.example.barberleomx.ui.screens.login

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController
) {
    // ------------------------
    // ESTADOS
    // ------------------------
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    var passwordVisible by remember { mutableStateOf(false) }

    val isFormValid = emailError == null &&
            passwordError == null &&
            email.isNotBlank() &&
            password.isNotBlank()

    // ------------------------
    // UI
    // ------------------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        // ------------------------
        // CORREO
        // ------------------------
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = when {
                    it.isBlank() -> "El correo es obligatorio"
                    !isValidEmail(it) -> "Correo no válido"
                    else -> null
                }
            },
            label = { Text("Correo electrónico") },
            singleLine = true,
            isError = emailError != null,
            modifier = Modifier.fillMaxWidth()
        )

        if (emailError != null) {
            Text(
                text = emailError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ------------------------
        // CONTRASEÑA
        // ------------------------
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = if (it.isBlank()) {
                    "La contraseña es obligatoria"
                } else {
                    null
                }
            },
            label = { Text("Contraseña") },
            singleLine = true,
            isError = passwordError != null,
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            Icons.Default.Visibility
                        else
                            Icons.Default.VisibilityOff,
                        contentDescription = "Mostrar u ocultar contraseña"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (passwordError != null) {
            Text(
                text = passwordError!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // ------------------------
        // BOTÓN
        // ------------------------
        Button(
            onClick = {
                // SOLO navegación (sin BD, sin guardar sesión)
                navController.navigate("barber_list") {
                    popUpTo("login") { inclusive = true }
                }
            },
            enabled = isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Iniciar sesión")
        }
    }
}

// ------------------------
// VALIDACIÓN DE CORREO
// ------------------------
private fun isValidEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
