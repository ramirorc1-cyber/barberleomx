package com.example.barberleomx.ui.data.repository

import com.example.barberleomx.ui.data.dao.BookingDao
import com.example.barberleomx.ui.data.model.Booking
import kotlinx.coroutines.flow.Flow

class BookingRepository(private val bookingDao: BookingDao) {

    val allBookings: Flow<List<Booking>> = bookingDao.getAllBookings()

    suspend fun insertBooking(booking: Booking) {
        bookingDao.insertBooking(booking)
    }
}
