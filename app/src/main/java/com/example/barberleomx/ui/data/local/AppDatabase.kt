package com.example.barberleomx.ui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barberleomx.ui.data.local.entity.*
import com.example.barberleomx.ui.data.local.entity.dao.*

@Database(
    entities = [
        Payment::class,
        Booking::class,
        ServicePaymentEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun paymentDao(): PaymentDao
    abstract fun bookingDao(): BookingDao
    abstract fun servicePaymentDao(): ServicePaymentDao
}
