package com.example.barberleomx

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    val prefs = getSharedPreferences("session", Context.MODE_PRIVATE)
    val startDestination = if (prefs.getBoolean("logged", false)) {
        "barber_list"
    } else {
        "login"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navController)
        }
    }
}
