package com.example.barberleomx.ui.session

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("barber_session", Context.MODE_PRIVATE)

    fun saveLogin(email: String) {
        prefs.edit {
            putBoolean("is_logged", true)
                .putString("email", email)
        }
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged", false)
    }

    fun saveSelectedBarber(barberName: String) {
        prefs.edit {
            putString("selected_barber", barberName)
        }
    }

    fun getSelectedBarber(): String {
        return prefs.getString("selected_barber", "") ?: ""
    }

    fun logout() {
        prefs.edit { clear() }
    }
}
