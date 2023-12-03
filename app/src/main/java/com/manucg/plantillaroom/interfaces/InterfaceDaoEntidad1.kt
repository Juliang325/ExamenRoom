package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Entidad1

@Dao
interface InterfaceDaoEntidad1 {
    @Insert
    fun addEntidad1(entidad : Entidad1)

    @Query("SELECT * FROM entidad1")
    fun getEntidades1() : MutableList<Entidad1>

    @Query("SELECT * FROM entidad1 WHERE nombre LIKE :nombre")
    fun getEntidad1(nombre: String) : Entidad1

    @Update
    fun updateEntidad1(entidad : Entidad1)

    @Delete
    fun deleteEntidad1(entidad: Entidad1)

    @Query("DELETE FROM entidad1")
    fun borraTablaEntidad1()

}
