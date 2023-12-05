package com.julian.plantillaroom.modelo.daos

import androidx.room.*
import com.julian.plantillaroom.modelo.entidades.Asignatura

@Dao
interface DaoAsignatura {

    @Insert
    fun addAsignatura(entidad : Asignatura)

    @Query("SELECT * FROM asignaturas_table")
    fun getAsignaturas() : MutableList<Asignatura>

    @Query("SELECT * FROM asignaturas_table WHERE nombre LIKE :nombre")
    fun getAsignatura(nombre: String) : Asignatura

    @Update
    fun updateAsignatura(entidad : Asignatura)

    @Delete
    fun deleteAsignatura(entidad: Asignatura)

    @Query("DELETE FROM asignaturas_table")
    fun borraTablaAsignatura()

}
