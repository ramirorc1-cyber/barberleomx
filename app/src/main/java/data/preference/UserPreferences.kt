package com.example.barberleomx.data.preferences

import android.content.Context

class UserPreferences(context: Context) {

    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUserType(type: String) {
        prefs.edit().putString("user_type", type).apply()
    }

    fun getUserType(): String? {
        return prefs.getString("user_type", null)
    }
}

