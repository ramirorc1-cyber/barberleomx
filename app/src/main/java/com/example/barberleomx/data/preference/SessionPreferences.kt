package com.example.barberleomx.data.preferences

import android.content.Context

class SessionPreferences(context: Context) {

    private val prefs = context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    )

    companion object {
        private const val PREF_NAME = "barber_session"
        private const val KEY_LOGGED_IN = "is_logged_in"
        private const val KEY_USER_ROLE = "user_role"
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_LOGGED_IN, isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_LOGGED_IN, false)
    }

    fun setUserRole(role: String) {
        prefs.edit().putString(KEY_USER_ROLE, role).apply()
    }

    fun getUserRole(): String? {
        return prefs.getString(KEY_USER_ROLE, null)
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
