package com.example.barberleomx.data.filestream

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class ReportFileManager(private val context: Context) {

    private val fileName = "reporte_citas.txt"

    fun saveReport(content: String) {
        val fileOutput: FileOutputStream =
            context.openFileOutput(fileName, Context.MODE_PRIVATE)

        fileOutput.write(content.toByteArray())
        fileOutput.close()
    }

    fun readReport(): String {
        val file = File(context.filesDir, fileName)

        if (!file.exists()) return "No hay reporte guardado"

        val fileInput = FileInputStream(file)
        val content = fileInput.bufferedReader().use { it.readText() }
        fileInput.close()

        return content
    }
}
