package com.manucg.plantillaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "entidad3",
    primaryKeys = ["refEntidad2", "refEntidad4"],
    foreignKeys = [
        ForeignKey(
            entity = Entidad2::class,
            parentColumns = ["idEntidad2"],
            childColumns = ["refEntidad2"]
        ),
        ForeignKey(
            entity = Entidad4::class,
            parentColumns = ["idEntidad4"],
            childColumns = ["refEntidad4"]
        )
    ]
)
data class Entidad3(
    @ColumnInfo(name = "refEntidad2")
    var refEntidad2 : Int,

    @ColumnInfo(name = "refEntidad4")
    var refEntidad4 : Int
) {

    override fun toString(): String {
        return "Entidad3 (refEntidad2= $refEntidad2, refEntidad4= $refEntidad4)"
    }


}
