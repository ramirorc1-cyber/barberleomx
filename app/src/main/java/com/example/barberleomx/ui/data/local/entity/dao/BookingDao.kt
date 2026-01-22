package com.example.barberleomx.ui.data.local.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.barberleomx.ui.data.local.entity.Booking
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingDao {

    @Insert
    suspend fun insert(booking: Booking)

    @Query("SELECT * FROM bookings")
    fun getAllBookings(): Flow<List<Booking>>
}
