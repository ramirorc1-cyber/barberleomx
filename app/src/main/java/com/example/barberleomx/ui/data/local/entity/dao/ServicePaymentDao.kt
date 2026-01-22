package com.example.barberleomx.ui.data.local.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.barberleomx.ui.data.local.entity.ServicePaymentEntity

@Dao
interface ServicePaymentDao {

    @Insert
    suspend fun insert(servicePayment: ServicePaymentEntity)

    @Query("SELECT * FROM service_payments WHERE paymentId = :paymentId")
    suspend fun getServicesForPayment(paymentId: Int): List<ServicePaymentEntity>
}
