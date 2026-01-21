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
fun BookingScreen(navController: NavController, barberId: Int) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val db = BarberDatabase.getDatabase(context)
    val repository = remember { BookingRepository(db.bookingDao()) }

    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Agendar cita") })
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Cita con Barber Leo #$barberId", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Fecha (ej. 2025-02-10)") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Hora (ej. 15:00)") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    scope.launch {
                        val booking = Booking(
                            barberId = barberId,
                            barberName = "Barber Leo",
                            date = date,
                            time = time
                        )

                        repository.insertBooking(booking)

                        Toast.makeText(
                            context,
                            "Cita agendada correctamente",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.popBackStack()
                    }
                }
            ) {
                Text("Guardar cita")
            }
        }
    }
}
