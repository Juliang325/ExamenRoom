package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Entidad4

@Dao
interface InterfaceDaoEntidad4 {

    @Insert
    fun addEntidad4(entidad : Entidad4)

    @Query("SELECT * FROM entidad4")
    fun getEntidades4() : MutableList<Entidad4>

    @Query("SELECT * FROM entidad4 WHERE nombre LIKE :nombre")
    fun getEntidad4(nombre: String) : Entidad4

    @Update
    fun updateEntidad4(entidad : Entidad4)

    @Delete
    fun deleteEntidad4(entidad: Entidad4)

    @Query("DELETE FROM entidad4")
    fun borraTablaEntidad4()

}
