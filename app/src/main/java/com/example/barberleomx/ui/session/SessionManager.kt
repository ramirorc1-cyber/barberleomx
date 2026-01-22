package com.example.barberleomx.ui.session

import android.content.Context

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences(
        "barber_session",
        Context.MODE_PRIVATE
    )

    fun saveLogin() {
        prefs.edit().putBoolean("is_logged", true).apply()
    }

    fun isLogged(): Boolean {
        return prefs.getBoolean("is_logged", false)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}
