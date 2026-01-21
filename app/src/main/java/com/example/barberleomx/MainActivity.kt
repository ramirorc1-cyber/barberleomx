package com.example.barberleomx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.navigation.NavGraph
import com.example.barberleomx.ui.session.SessionManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sessionManager = SessionManager(this)
        val startDestination = if (sessionManager.isLogged()) {
            "barberias"
        } else {
            "login"
        }

        setContent {
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                startDestination = startDestination
            )
        }
    }
}
