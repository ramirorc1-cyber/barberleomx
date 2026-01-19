package com.example.barberleomx.ui.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barberleomx.data.local.entity.Booking
import com.example.barberleomx.data.repository.BookingRepository
import kotlinx.coroutines.launch

class BookingViewModel(
    private val repository: BookingRepository
) : ViewModel() {

    val bookings = repository.getAllBookings()

    fun addBooking(booking: Booking) {
        viewModelScope.launch {
            repository.insertBooking(booking)
        }
    }
}
