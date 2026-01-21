package com.example.barberleomx.ui.session

import android.content.Context
import androidx.core.content.edit

class SessionManager(context: Context) {

    private val prefs =
        context.getSharedPreferences("barber_session", Context.MODE_PRIVATE)

    fun saveLogin(email: String) {
        prefs.edit {
            putBoolean("is_logged", true)
                .putString("email", email)
        }
    }

    fun isLogged(): Boolean {
        return prefs.getBoolean("is_logged", false)
    }

    fun logout() {
        prefs.edit { clear() }
    }
}
