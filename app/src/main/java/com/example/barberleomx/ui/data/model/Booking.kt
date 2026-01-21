package com.example.barberleomx.ui.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barberId: Int,
    val barberName: String,
    val date: String,
    val time: String
)
