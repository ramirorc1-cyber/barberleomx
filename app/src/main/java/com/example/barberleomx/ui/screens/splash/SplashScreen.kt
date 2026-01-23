package com.example.barberleomx.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.barberleomx.R

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(5000) // 2 segundos
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Image(
        painter = painterResource(id = R.drawable.inicio),
        contentDescription = "Splash",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
