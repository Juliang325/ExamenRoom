package com.julian.plantillaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "profesor_asignatura_table",
    primaryKeys = ["refProfesor", "refAsignatura"],
    foreignKeys = [
        ForeignKey(
            entity = Profesor::class,
            parentColumns = ["idProfesor"],
            childColumns = ["refProfesor"]
        ),
        ForeignKey(
            entity = Asignatura::class,
            parentColumns = ["idAsignatura"],
            childColumns = ["refAsignatura"]
        )
    ]
)
data class Profesor_Asignatura(
    @ColumnInfo(name = "refProfesor")
    var refProfesor : Int,

    @ColumnInfo(name = "refAsignatura")
    var refAsignatura : Int
) {

    override fun toString(): String {
        return "Profesor_Asignatura (refProfesor= $refProfesor, refAsignatura= $refAsignatura)"
    }


}