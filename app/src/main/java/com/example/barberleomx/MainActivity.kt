package com.example.barberleomx

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.navigation.NavGraph
import com.example.barberleomx.ui.theme.BarberLeoMXTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ AQUÍ sí existe el Context
        val prefs = getSharedPreferences("session", Context.MODE_PRIVATE)

        val startDestination = if (prefs.getBoolean("logged", false)) {
            "barber_list"
        } else {
            "login"
        }

        setContent {
            BarberLeoMXTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    startDestination = startDestination,
                )
            }
        }
    }
}
