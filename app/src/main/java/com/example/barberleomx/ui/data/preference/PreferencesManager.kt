package com.example.barberleomx.ui.data.preference

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("barber_prefs", Context.MODE_PRIVATE)

    fun saveLogin(email: String) {
        prefs.edit()
            .putBoolean("is_logged", true)
            .putString("email", email)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged", false)
    }

    fun logout() {
        prefs.edit()
            .clear()
            .apply()
    }
}
