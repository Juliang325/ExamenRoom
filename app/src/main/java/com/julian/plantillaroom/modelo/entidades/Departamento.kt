package com.julian.plantillaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departamentos_table")
data class Departamento (
    @PrimaryKey
    @ColumnInfo(name="idDepartamento")
    var idDepartamento : String,

    @ColumnInfo("nombre")
    var nombre : String
){
    override fun toString(): String {
        return "Departamento (departamentoId= $idDepartamento, nombre=$nombre)"
    }

}