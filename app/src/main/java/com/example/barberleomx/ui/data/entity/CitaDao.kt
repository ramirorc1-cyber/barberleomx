package com.example.barberleomx.ui.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.barberleomx.ui.data.entity.CitaEntity

@Dao
interface CitaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarCita(cita: CitaEntity)

    @Query("SELECT * FROM citas ORDER BY id DESC")
    suspend fun obtenerCitas(): List<CitaEntity>
}
