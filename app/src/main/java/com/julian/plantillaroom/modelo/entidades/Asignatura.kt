package com.julian.plantillaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asignaturas_table")
data class Asignatura(
    @ColumnInfo(name = "nombre")
    var nombre : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idAsignatura")
    var idAsignatura : Int = 0

    override fun toString(): String {
        return "Asignatura (idAsignatura= $idAsignatura, nombre= $nombre)"
    }


}