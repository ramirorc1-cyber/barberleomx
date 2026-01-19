package com.example.barberleomx.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.barberleomx.data.local.entity.Booking

@Database(
    entities = [Booking::class],
    version = 1,
    exportSchema = false
)
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
                    "barber_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
