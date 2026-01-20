package com.example.barberleomx.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.barberleomx.data.local.dao.BookingDao
import com.example.barberleomx.data.local.entity.Booking

@Database(
    entities = [Booking::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookingDao(): BookingDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "barber_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
