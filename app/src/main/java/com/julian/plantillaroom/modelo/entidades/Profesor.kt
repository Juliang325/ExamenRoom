package com.julian.plantillaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "profesores_table",
    foreignKeys = [
        ForeignKey(
            entity = Departamento::class,
            parentColumns = ["idDepartamento"],
            childColumns = ["refDepartamento"]
        )
    ])
data class Profesor(
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name = "apellido")
    var apellido : String,
    @ColumnInfo(name="refDepartamento")
    var refDepartamento : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idProfesor")
    var idProfesor : Int = 0

    override fun toString(): String {
        return "Entidad2(idEntidad2= $idProfesor, nombre= $nombre, refDepartamento=$refDepartamento)"
    }

}