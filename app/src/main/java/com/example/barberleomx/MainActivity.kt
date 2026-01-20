package com.example.barberleomx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.data.preferences.SessionPreferences
import com.example.barberleomx.ui.navigation.AppNavigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.barberleomx.ui.navigation.NavGraph
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navController)
        }
    }
}
