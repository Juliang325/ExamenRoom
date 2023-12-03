package com.manucg.plantillaroom

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.manucg.plantillaroom.conexion.BDRoom
import com.manucg.plantillaroom.entidades.Entidad1
import com.manucg.plantillaroom.entidades.Entidad2
import com.manucg.plantillaroom.entidades.Entidad3
import com.manucg.plantillaroom.entidades.Entidad4
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad1
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad2
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad3
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad4

class MainActivity : AppCompatActivity() {
    lateinit var conexion: BDRoom
    lateinit var daoEntidad1: InterfaceDaoEntidad1
    lateinit var daoEntidad2: InterfaceDaoEntidad2
    lateinit var daoEntidad3: InterfaceDaoEntidad3
    lateinit var daoEntidad4: InterfaceDaoEntidad4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        borraTablas()
        pruebaEntidad1()
        pruebaEntidad2()
        pruebaEntidad4()
        pruebaEntidad3()
        borraTablas()
    }

    fun setup() {
        conexion = BDRoom.getBaseDatos(this)
        daoEntidad1 = conexion.DaoEntidad1()
        daoEntidad2 = conexion.DaoEntidad2()
        daoEntidad3 = conexion.DaoEntidad3()
        daoEntidad4 = conexion.DaoEntidad4()
    }

    fun pruebaEntidad1() {
        /*AÑADIENDO */
        daoEntidad1.addEntidad1(Entidad1("Ent1"))
        daoEntidad1.addEntidad1(Entidad1("Ent10"))

        /*OBTENIENDO TODO */
        daoEntidad1.getEntidades1().forEach {
            Log.d("getEntidades1()", it.toString())
        }

        /*OTENIENDO UNO*/
        Log.d("getEntidad1()", daoEntidad1.getEntidad1("Ent1").toString())

        /*ACTUALIZANDO*/
        var entidad1Actualizado = daoEntidad1.getEntidad1("Ent10")
        entidad1Actualizado.nombre = "Ent10"
        daoEntidad1.updateEntidad1(entidad1Actualizado)
        daoEntidad1.getEntidades1().forEach {
            Log.d("updateEntidad1()", it.toString())
        }

        /*BORRANDO*/
        daoEntidad1.deleteEntidad1(entidad1Actualizado)
        daoEntidad1.getEntidades1().forEach {
            Log.d("getEntidades1()", it.toString())
        }

    }

    fun pruebaEntidad2() {
        /*AÑADIENDO */
        daoEntidad2.addEntidad2(Entidad2("Ent2", daoEntidad1.getEntidad1("Ent1").idEntidad1))
        daoEntidad2.addEntidad2(Entidad2("Ent20", daoEntidad1.getEntidad1("Ent1").idEntidad1))

        /*OBTENIENDO TODO */
        daoEntidad2.getEntidades2().forEach {
            Log.d("getEntidades2()", it.toString())
        }

        /*OTENIENDO UNO*/
        Log.d("getEntidad2()", daoEntidad2.getEntidad2("Ent2").toString())

        /*ACTUALIZANDO*/
        var entidad2Actualizado = daoEntidad2.getEntidad2("Ent20")
        entidad2Actualizado.nombre = "Ent20"
        daoEntidad2.updateEntidad2(entidad2Actualizado)
        daoEntidad2.getEntidades2().forEach {
            Log.d("updateEntidad2()", it.toString())
        }

        /*BORRANDO*/
        daoEntidad2.deleteEntidad2(entidad2Actualizado)
        daoEntidad2.getEntidades2().forEach {
            Log.d("deleteEntidad2()", it.toString())
        }

    }

    fun pruebaEntidad3() {
        /*AÑADIENDO */
        daoEntidad3.addEntidad3(
            Entidad3(
                daoEntidad2.getEntidad2("Ent2").idEntidad2,
                daoEntidad4.getEntidad4("Ent4").idEntidad4
            )
        )

        /*OBTENIENDO TODO */
        daoEntidad3.getEntidades3().forEach {
            Log.d("getEntidades3()", it.toString())
        }

        /*OTENIENDO UNO*/
        Log.d(
            "getEntidad3()",
            daoEntidad3.getEntidad3(
                    daoEntidad2.getEntidad2("Ent2").idEntidad2,
                    daoEntidad4.getEntidad4("Ent4").idEntidad4
            ).toString()
        )

        /*ACTUALIZANDO*/
        var entidad3Actualizado = daoEntidad3.getEntidad3(
            daoEntidad2.getEntidad2("Ent2").idEntidad2,
            daoEntidad4.getEntidad4("Ent4").idEntidad4
        )
        entidad3Actualizado.refEntidad2 = daoEntidad2.getEntidad2("Ent2").idEntidad2
        daoEntidad3.updateEntidad3(entidad3Actualizado)
        daoEntidad3.getEntidades3().forEach {
            Log.d("updateEntidad3()", it.toString())
        }

        /*BORRANDO*/
        daoEntidad3.deleteEntidad3(entidad3Actualizado)
        daoEntidad3.getEntidades3().forEach {
            Log.d("deleteEntidad3()", it.toString())
        }
    }

    fun pruebaEntidad4() {
        /*AÑADIENDO */
        daoEntidad4.addEntidad4(Entidad4("Ent4"))
        daoEntidad4.addEntidad4(Entidad4("Ent40"))

        /*OBTENIENDO TODO */
        daoEntidad4.getEntidades4().forEach {
            Log.d("getEntidades4()", it.toString())
        }

        /*OBTENIENDO UNO*/
        Log.d("getEntidad4()", daoEntidad4.getEntidad4("Ent4").toString())

        /*ACTUALIZANDO*/
        var entidad4Actualizado = daoEntidad4.getEntidad4("Ent40")
        entidad4Actualizado.nombre = "Ent40"
        daoEntidad4.updateEntidad4(entidad4Actualizado)
        daoEntidad4.getEntidades4().forEach {
            Log.d("updateEntidad4()", it.toString())
        }

        /*BORRANDO*/
        daoEntidad4.deleteEntidad4(entidad4Actualizado)
        daoEntidad4.getEntidades4().forEach {
            Log.d("deleteEntidad4()", it.toString())
        }


    }

    fun borraTablas() {
        daoEntidad3.borraTablaEntidad3()
        daoEntidad4.borraTablaEntidad4()
        daoEntidad2.borraTablaEntidad2()
        daoEntidad1.borraTablaEntidad1()


    }
}