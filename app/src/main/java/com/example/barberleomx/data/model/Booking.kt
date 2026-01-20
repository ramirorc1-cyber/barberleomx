package com.example.barberleomx.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class Booking(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val clientName: String,
    val service: String,
    val date: String,
    val time: String,
    val phone: String
)
