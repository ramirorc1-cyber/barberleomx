package com.example.barberleomx.ui.screens.barber

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.barberleomx.ui.components.ServiceItem
import com.example.barberleomx.ui.data.FakeServiceData
import com.example.barberleomx.ui.session.SessionManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDetailScreen(
    barberName: String,
    navController: NavController
) {
    val context = LocalContext.current
    val services = FakeServiceData.getServices(barberName)
    var total by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(barberName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        SessionManager(context).logout()
                        navController.navigate("login") {
                            popUpTo("barber_list") { inclusive = true }
                        }
                    }) {
                        Text("Salir")
                    }
                }
            )
        },
        bottomBar = {
            Surface(shadowElevation = 8.dp) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = "Total: $${total}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = {
                            navController.navigate("payment/$total")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = total > 0
                    ) {
                        Text("Continuar al pago")
                    }

                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(services) { service ->
                ServiceItem(service) {
                    total += service.price
                }
            }
        }
    }
}
