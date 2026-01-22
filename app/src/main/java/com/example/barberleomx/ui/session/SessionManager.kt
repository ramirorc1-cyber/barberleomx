package com.example.barberleomx.ui.session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("barber_session", Context.MODE_PRIVATE)

    fun login() {
        prefs.edit().putBoolean("logged_in", true).apply()
    }

    fun logout() {
        prefs.edit().clear().apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("logged_in", false)
    }
}
