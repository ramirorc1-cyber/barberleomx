package com.example.barberleomx.ui.data.local.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.barberleomx.ui.data.local.entity.Payment

@Dao
interface PaymentDao {

    @Insert
    suspend fun insert(payment: Payment)

    @Query("SELECT SUM(total) FROM payments")
    suspend fun getTotalSpent(): Int?

    @Query("SELECT * FROM payments ORDER BY timestamp DESC")
    suspend fun getAllPayments(): List<Payment>
}
