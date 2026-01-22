package com.example.barberleomx.ui.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val total: Int,
    val method: String,
    val timestamp: Long = System.currentTimeMillis()
)
