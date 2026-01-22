package com.example.barberleomx.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.ui.session.SessionManager
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val context = navController.context
    val sessionManager = SessionManager(context)

    LaunchedEffect(true) {
        delay(3000)
        if (sessionManager.isLogged()) {
            navController.navigate("barber_list") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.inicio_app),
            contentDescription = null,
            modifier = Modifier.size(220.dp)
        )
    }
}
