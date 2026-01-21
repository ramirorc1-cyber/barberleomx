package com.example.barberleomx.ui.session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("barber_session", Context.MODE_PRIVATE)

    fun saveLogin() {
        prefs.edit().putBoolean("isLogged", true).apply()
    }

    fun isLogged(): Boolean {
        return prefs.getBoolean("isLogged", false)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}
