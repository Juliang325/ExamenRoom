package com.julian.plantillaroom.modelo.daos

import androidx.room.*
import com.julian.plantillaroom.modelo.entidades.Profesor


@Dao
interface DaoProfesor {
    @Insert
    fun addProfesor(entidad : Profesor)

    @Query("SELECT * FROM profesores_table")
    fun getProfesores() : MutableList<Profesor>

    @Query("SELECT * FROM profesores_table WHERE nombre LIKE :nombre")
    fun getProfesor(nombre: String) : Profesor

    @Query("SELECT * FROM profesores_table WHERE refDepartamento LIKE :dep")
    fun getProfesores(dep: String) :  MutableList<Profesor>

    @Update
    fun updateProfesor(entidad : Profesor)

    @Delete
    fun deleteProfesor(entidad: Profesor)

    @Query("DELETE FROM profesores_table")
    fun borraTablaProfesor()
}
