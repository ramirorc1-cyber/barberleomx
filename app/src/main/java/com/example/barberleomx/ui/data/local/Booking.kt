package com.example.barberleomx.ui.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booking")
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val clientName: String,
    val date: String,
    val time: String,
    val service: String
)
