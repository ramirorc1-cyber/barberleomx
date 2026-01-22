package com.example.barberleomx.ui.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.barberleomx.ui.data.local.entity.dao.BookingDao
import com.example.barberleomx.ui.data.model.Booking

@Database(entities = [Booking::class], version = 1)
abstract class BarberDatabase : RoomDatabase() {

    abstract fun bookingDao(): BookingDao

    companion object {
        @Volatile
        private var INSTANCE: BarberDatabase? = null

        fun getDatabase(context: Context): BarberDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BarberDatabase::class.java,
                    "barber_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
