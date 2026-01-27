package com.example.barberleomx.ui.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.barberleomx.ui.data.entity.CitaEntity
import com.example.barberleomx.ui.data.entity.CitaDao

@Database(
    entities = [CitaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun citaDao(): CitaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "barber_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
