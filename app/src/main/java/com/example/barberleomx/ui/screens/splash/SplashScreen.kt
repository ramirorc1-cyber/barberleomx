package com.example.barberleomx.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.ui.navigation.Routes
import com.example.barberleomx.ui.session.SessionManager
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.LocalContext

@Composable
fun SplashScreen(navController: NavController) {

    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

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

    Image(
        painter = painterResource(R.drawable.inicio_app),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}
