package com.example.barberleomx.ui.data

import com.example.barberleomx.R
import com.example.barberleomx.ui.model.Barber

object FakeBarberData {

    val barberList = listOf(
        Barber(
            name = "BarberLeoMX",
            description = "Cortes clásicos y modernos con atención profesional.",
            image = R.drawable.leo
        ),
        Barber(
            name = "Doberman",
            description = "Estilo urbano, precisión y carácter.",
            image = R.drawable.doberman
        ),
        Barber(
            name = "Blassed",
            description = "Barbería moderna con acabados premium.",
            image = R.drawable.blessed
        )
    )
}
