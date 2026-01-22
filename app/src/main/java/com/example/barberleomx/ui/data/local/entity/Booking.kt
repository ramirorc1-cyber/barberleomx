package com.example.barberleomx.ui.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barberName: String,
    val total: Int,
    val date: Long = System.currentTimeMillis()
)