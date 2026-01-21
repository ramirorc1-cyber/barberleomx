package com.example.barberleomx.ui.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.barberleomx.ui.data.model.Booking
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingDao {

    @Insert
    suspend fun insertBooking(booking: Booking)

    @Query("SELECT * FROM bookings")
    fun getAllBookings(): Flow<List<Booking>>
}
