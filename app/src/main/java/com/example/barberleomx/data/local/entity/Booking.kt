package com.example.barberleomx.data.local.entity

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
