package com.example.barberleomx.ui.data

import com.example.barberleomx.ui.model.Service

object FakeServiceData {

    fun getServices(barberName: String): List<Service> {
        return when (barberName) {
            "BarberLeoMX" -> listOf(
                Service("Corte clásico", 150),
                Service("Corte + barba", 220),
                Service("Barba", 100),
                Service("Diseño especial", 180)
            )

            "Doberman" -> listOf(
                Service("Fade", 180),
                Service("Fade + barba", 250)
            )

            else -> listOf(
                Service("Corte básico", 120)
            )
        }
    }
}
