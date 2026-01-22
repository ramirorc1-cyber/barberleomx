package com.example.barberleomx.ui.data

import com.example.barberleomx.R
import com.example.barberleomx.ui.model.Barber

object FakeBarberData {

    val barberList = listOf(
        Barber(
            name = "BarberLeoMX",
            description = "Cortes clásicos y modernos con estilo.",
            image = R.drawable.leo
        ),
        Barber(
            name = "Doberman",
            description = "Estilo urbano y atención premium.",
            image = R.drawable.doberman
        ),
        Barber(
            name = "Blassed",
            description = "Barbería moderna y profesional.",
            image = R.drawable.blessed
        )
    )
}
