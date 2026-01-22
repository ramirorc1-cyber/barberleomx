package com.example.barberleomx.ui.screens.gastos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.barberleomx.ui.data.database.AppDatabase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastosScreen() {
    val context = LocalContext.current
    var total by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            total = AppDatabase
                .getDatabase(context)
                .paymentDao()
                .getTotalSpent() ?: 0
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mis gastos") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
        ) {
            Text("Total gastado", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text(
                "$$total MXN",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}
