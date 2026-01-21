package com.example.barberleomx.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.barberleomx.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(9000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Image(
        painter = painterResource(R.drawable.inicio_app),
        contentDescription = "Splash",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
