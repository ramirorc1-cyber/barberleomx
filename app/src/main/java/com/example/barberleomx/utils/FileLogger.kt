package com.example.barberleomx.utils

import android.content.Context
import java.io.File

object FileLogger {

    fun saveLog(context: Context, text: String) {
        val file = File(context.filesDir, "logs.txt")
        file.appendText("$text\n")
    }
}
