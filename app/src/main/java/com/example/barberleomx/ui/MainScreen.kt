package com.example.barberleomx.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Text(text = "Hola Barber Leo 💈")
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
