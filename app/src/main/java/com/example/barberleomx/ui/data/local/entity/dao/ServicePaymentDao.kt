package com.example.barberleomx.ui.data.local.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.barberleomx.ui.data.local.entity.ServicePaymentEntity

@Dao
interface ServicePaymentDao {

    @Insert
    suspend fun insertPayment(payment: ServicePaymentEntity)

    @Query("SELECT * FROM payments ORDER BY date DESC")
    suspend fun getAllPayments(): List<ServicePaymentEntity>

    @Query("SELECT SUM(price) FROM payments")
    suspend fun getTotalSpent(): Int?
}
