package com.example.barberleomx.utils

import android.content.Context

class PreferencesManager(context: Context) {

    private val prefs = context.getSharedPreferences(
        "barber_prefs",
        Context.MODE_PRIVATE
    )

    fun saveUser(name: String) {
        prefs.edit().putString("user_name", name).apply()
    }

    fun getUser(): String? {
        return prefs.getString("user_name", null)
    }
}
