package com.example.barberleomx.ui.screens.login

import androidx.compose.runtime.Composable

class LoginScreen {
}
@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Iniciar sesión", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate("home")
            }
        ) {
            Text("Entrar")
        }
    }
}
