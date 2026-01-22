package com.example.barberleomx.ui.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class ServicePaymentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barberName: String,
    val serviceName: String,
    val price: Int,
    val paymentMethod: String,
    val date: Long
)
