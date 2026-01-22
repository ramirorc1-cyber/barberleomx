package com.example.barberleomx.ui.session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("barber_session", Context.MODE_PRIVATE)

    fun saveLogin() {
        prefs.edit().putBoolean("logged", true).apply()
    }

    fun logout() {
        prefs.edit().clear().apply()
    }

    fun isLogged(): Boolean {
        return prefs.getBoolean("logged", false)
    }
}
