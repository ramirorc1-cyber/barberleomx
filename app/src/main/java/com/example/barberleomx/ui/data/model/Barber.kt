package com.example.barberleomx.ui.data.model

import androidx.annotation.DrawableRes

data class Barber(
    val name: String,
    val description: String,
    @DrawableRes val image: Int
)
