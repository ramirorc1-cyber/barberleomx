package com.example.barberleomx.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.barberleomx.data.local.dao.ServicePaymentDao
import com.example.barberleomx.data.local.entity.ServicePaymentEntity

@Database(
    entities = [ServicePaymentEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun paymentDao(): ServicePaymentDao

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
