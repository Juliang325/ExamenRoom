package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "entidad2",
    foreignKeys = [
        ForeignKey(
            entity = Entidad1::class,
            parentColumns = ["idEntidad1"],
            childColumns = ["refEntidad1"]
        )
    ])
data class Entidad2(
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name="refEntidad1")
    var refEntidad1 : Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idEntidad2")
    var idEntidad2 : Int = 0

    override fun toString(): String {
        return "Entidad2(idEntidad2= $idEntidad2, nombre= $nombre, refEntidad1=$refEntidad1)"
    }

}
