package com.julian.plantillaroom.modelo.daos

import androidx.room.*
import com.julian.plantillaroom.modelo.entidades.Departamento

@Dao
interface DaoDepartamento {
    @Insert
    fun addDepartamento(departamento : Departamento)

    @Query("SELECT * FROM departamentos_table")
    fun getDepartamentos() : MutableList<Departamento>

    @Query("SELECT * FROM departamentos_table WHERE nombre LIKE :nombre")
    fun getDepartamento(nombre: String) : Departamento

    @Update
    fun updateDepartamento(departamento : Departamento)

    @Delete
    fun deleteDepartamento(departamento: Departamento)

    @Query("DELETE FROM departamentos_table")
    fun borraTablaDepartamento()

}
