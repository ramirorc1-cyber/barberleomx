package com.example.barberleomx.ui.screens.barberlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.R
import com.example.barberleomx.ui.session.SessionManager

data class BarberItem(
    val name: String,
    val description: String,
    val logo: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberListScreen(navController: NavController) {

    val barberias = listOf(
        BarberItem("BarberLeoMX", "Barbería profesional", R.drawable.leo),
        BarberItem("Blassed", "Estilo urbano", R.drawable.blessed),
        BarberItem("Doberman", "Cortes clásicos", R.drawable.doberman)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Selecciona una barbería") }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(barberias) { barber ->
                val context = LocalContext.current
                val sessionManager = remember { SessionManager(context) }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            sessionManager.saveSelectedBarber("BarberLeoMX")
                            navController.navigate("barber_detail/BarberLeoMX")
                        }
                ) {
                    // contenido
                }

                Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(barber.logo),
                            contentDescription = barber.name,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(Modifier.width(16.dp))

                        Column {
                            Text(barber.name, style = MaterialTheme.typography.titleMedium)
                            Text(barber.description)
                        }
                    }
                }
            }
        }
    }
