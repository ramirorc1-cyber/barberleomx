package com.example.barberleomx.data.repository

import com.example.barberleomx.data.local.dao.BookingDao
import com.example.barberleomx.data.local.entity.Booking
import kotlinx.coroutines.flow.Flow

class BookingRepository(
    private val bookingDao: BookingDao
) {

    fun getAllBookings(): Flow<List<Booking>> {
        return bookingDao.getAllBookings()
    }

    suspend fun insertBooking(booking: Booking) {
        bookingDao.insertBooking(booking)
    }
}
