package com.example.barberleomx.ui.screens.appointment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*

@Composable
fun AgendarCitaScreen(
    navController: NavController,
    barberName: String,
    total: Int
) {
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = "Agendar cita",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // -------- FECHA --------
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    DatePickerDialog(
                        context,
                        { _, year, month, day ->
                            fecha = "$day/${month + 1}/$year"
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }
            ) {
                Text(if (fecha.isEmpty()) "Seleccionar fecha" else "Fecha: $fecha")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // -------- HORA --------
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    TimePickerDialog(
                        context,
                        { _, hour, minute ->
                            hora = String.format("%02d:%02d", hour, minute)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                    ).show()
                }
            ) {
                Text(if (hora.isEmpty()) "Seleccionar hora" else "Hora: $hora")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Divider()

            Spacer(modifier = Modifier.height(16.dp))

            Text("Barbería: $barberName")
            Text("Total a pagar: $$total")
        }

        // -------- BOTÓN --------
        Button(
            enabled = fecha.isNotEmpty() && hora.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                navController.navigate(
                    "payment/$barberName/$total?fecha=$fecha&hora=$hora"
                )
            }
        ) {
            Text("Continuar al pago")
        }
    }
}
