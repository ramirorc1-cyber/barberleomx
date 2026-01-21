package com.example.barberleomx.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.barberleomx.ui.model.Haircut

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HaircutBottomSheet(
    onDismiss: () -> Unit,
    onConfirm: (Haircut) -> Unit
) {

    val haircuts = listOf(
        Haircut("Casquete Corto ", "100 $"),
        Haircut("Moicano ", "120 $"),
        Haircut("Taper Fade", "150 $"),
        Haircut("Clasico", "110 $"),
        Haircut("Low Fade ", "130 $")
    )

    var selected by remember { mutableStateOf(haircuts[1]) }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "Selecciona tu tipo de corte",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(16.dp))

            haircuts.forEach { haircut ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = haircut == selected,
                            onClick = { selected = haircut }
                        )
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = haircut == selected,
                        onClick = { selected = haircut }
                    )

                    Spacer(Modifier.width(8.dp))

                    Text(
                        text = haircut.name,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = haircut.price,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { onConfirm(selected) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Añadir tipo de corte")
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}
