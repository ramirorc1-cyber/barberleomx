package com.example.barberleomx.ui.screens.booking

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.data.database.BarberDatabase
import com.example.barberleomx.ui.data.model.Booking
import com.example.barberleomx.ui.data.repository.BookingRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    navController: NavController,
    barberId: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Booking del barbero ID: $barberId")

        Button(onClick = { navController.popBackStack() }) {
            Text("Regresar")
        }
    }
}
