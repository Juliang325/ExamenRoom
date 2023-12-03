package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "entidad1")
data class Entidad1 (
    @ColumnInfo("nombre")
    var nombre : String
    ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idEntidad1")
    var idEntidad1 = 0

    override fun toString(): String {
        return "Entidad1 (idEntidad1= $idEntidad1, nombre=$nombre)"
    }

}
