package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Entidad2

@Dao
interface InterfaceDaoEntidad2 {
    @Insert
    fun addEntidad2(entidad : Entidad2)

    @Query("SELECT * FROM entidad2")
    fun getEntidades2() : MutableList<Entidad2>

    @Query("SELECT * FROM entidad2 WHERE nombre LIKE :nombre")
    fun getEntidad2(nombre: String) : Entidad2

    @Update
    fun updateEntidad2(entidad : Entidad2)

    @Delete
    fun deleteEntidad2(entidad: Entidad2)

    @Query("DELETE FROM entidad2")
    fun borraTablaEntidad2()
}
