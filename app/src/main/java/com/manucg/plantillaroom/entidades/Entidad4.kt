package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entidad4")
data class Entidad4(
    @ColumnInfo(name = "nombre")
    var nombre : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idEntidad4")
    var idEntidad4 : Int = 0

    override fun toString(): String {
        return "Entidad4 (idEntidad4= $idEntidad4, nombre= $nombre)"
    }


}
