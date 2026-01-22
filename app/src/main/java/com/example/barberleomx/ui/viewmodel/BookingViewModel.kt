package com.example.barberleomx.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.barberleomx.ui.data.database.AppDatabase
import com.example.barberleomx.ui.data.model.Booking
import com.example.barberleomx.ui.data.repository.BookingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookingViewModel(application: Application) : AndroidViewModel(application) {

    private val bookingDao = AppDatabase.getDatabase(application).bookingDao()
    private val repository = BookingRepository(bookingDao)

    val allBookings: Flow<List<Booking>> = repository.allBookings

    fun addBooking(booking: Booking) {
        viewModelScope.launch {
            repository.insertBooking(booking)
        }
    }
}
