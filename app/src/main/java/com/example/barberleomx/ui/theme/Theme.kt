package com.example.barberleomx.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkBarberColorScheme = darkColorScheme(
    primary = BarberGold,
    secondary = BarberRed,

    background = BarberBlack,
    surface = BarberDarkGray,

    onPrimary = BarberBlack,
    onSecondary = BarberWhite,

    onBackground = BarberWhite,
    onSurface = BarberWhite
)

@Composable
fun BarberLeoMXTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkBarberColorScheme,
        typography = Typography(),
        content = content
    )
}
