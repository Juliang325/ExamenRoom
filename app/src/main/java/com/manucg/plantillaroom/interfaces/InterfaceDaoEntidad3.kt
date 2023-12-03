package com.manucg.plantillaroom.interfaces

import androidx.room.*
import com.manucg.plantillaroom.entidades.Entidad2
import com.manucg.plantillaroom.entidades.Entidad3

@Dao
interface InterfaceDaoEntidad3 {
    @Insert
    fun addEntidad3(entidad : Entidad3)

    @Query("SELECT * FROM entidad3")
    fun getEntidades3() : MutableList<Entidad3>
    @Query("SELECT * FROM entidad3 WHERE refEntidad2 = :refEntidad2 AND refEntidad4 = :refEntidad4")
    fun getEntidad3(refEntidad2 : Int, refEntidad4 : Int) : Entidad3

    @Query("SELECT ent2.* FROM entidad3 ent3 JOIN entidad2 ent2 ON ent3.refEntidad2 = ent2.idEntidad2 JOIN entidad4 ent4  ON ent3.refEntidad4 = ent4.idEntidad4 WHERE ent4.nombre = :nombreEntidad4")
    fun getEntidades2ByNombreEntidad4(nombreEntidad4:String) : MutableList<Entidad2>

    @Update
    fun updateEntidad3(entidad : Entidad3)

    @Delete
    fun deleteEntidad3(entidad: Entidad3)

    @Query("DELETE FROM entidad3")
    fun borraTablaEntidad3()
}
