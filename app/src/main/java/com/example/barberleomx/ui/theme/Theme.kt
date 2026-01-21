package com.example.barberleomx.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val ColorScheme = lightColorScheme(
    primary = PetrolBlue,
    secondary = Gold,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = PetrolBlue
)

@Composable
fun BarberLeoMXTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography(),
        content = content
    )
}
