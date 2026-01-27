package com.example.barberleomx.ui.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "citas")
data class CitaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barberName: String,
    val total: Int,
    val fecha: String,
    val hora: String
)
