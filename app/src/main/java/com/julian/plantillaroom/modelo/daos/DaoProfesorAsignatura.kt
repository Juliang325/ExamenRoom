package com.julian.plantillaroom.modelo.daos

import androidx.room.*
import com.julian.plantillaroom.modelo.entidades.Profesor
import com.julian.plantillaroom.modelo.entidades.Profesor_Asignatura

@Dao
interface DaoProfesorAsignatura {
    @Insert
    fun addProfesor_Asignatura(entidad : Profesor_Asignatura)

    @Query("SELECT * FROM profesor_asignatura_table")
    fun getEntidades3() : MutableList<Profesor_Asignatura>

    @Query("SELECT * FROM profesor_asignatura_table WHERE refProfesor = :refProfesor AND refAsignatura = :refAsignatura")
    fun getEntidad3(refProfesor : Int, refAsignatura : Int) : Profesor_Asignatura

    @Query("SELECT ent2.* FROM profesor_asignatura_table ent3 JOIN profesores_table ent2 ON ent3.refProfesor = ent2.idProfesor JOIN asignaturas_table ent4  ON ent3.refAsignatura = ent4.idAsignatura WHERE ent4.nombre = :nombreAsignatura")
    fun getProfesoresByAsignatura(nombreAsignatura:String) : MutableList<Profesor>

    @Update
    fun updateProfesor_Asignatura(entidad : Profesor_Asignatura)

    @Delete
    fun deleteProfesor_Asignatura(entidad: Profesor_Asignatura)

    @Query("DELETE FROM profesor_asignatura_table")
    fun borraTablaProfesor_Asignatura()
}