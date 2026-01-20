package com.example.barberleomx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.barberleomx.data.preferences.SessionPreferences
import com.example.barberleomx.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 SIMULACIÓN DE LOGIN
        val sessionPrefs = SessionPreferences(this)

        if (!sessionPrefs.isLoggedIn()) {
            sessionPrefs.setLoggedIn(true)
            sessionPrefs.setUserRole("CLIENTE") // o "BARBERO"
        }

        setContent {
            AppNavigation()
        }
    }
}
