package com.manucg.plantillaroom.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manucg.plantillaroom.entidades.Entidad1
import com.manucg.plantillaroom.entidades.Entidad2
import com.manucg.plantillaroom.entidades.Entidad3
import com.manucg.plantillaroom.entidades.Entidad4
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad1
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad2
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad3
import com.manucg.plantillaroom.interfaces.InterfaceDaoEntidad4


//Definir las entidades
@Database(entities = [Entidad1::class, Entidad2::class, Entidad3::class, Entidad4::class], version = 1)
abstract class BDRoom : RoomDatabase() {

    // Definición de los daos
    abstract fun DaoEntidad1(): InterfaceDaoEntidad1
    abstract fun DaoEntidad2(): InterfaceDaoEntidad2
    abstract fun DaoEntidad3(): InterfaceDaoEntidad3
    abstract fun DaoEntidad4(): InterfaceDaoEntidad4

    companion object {
        private var INSTANCE: BDRoom? = null

        fun getBaseDatos(context: Context): BDRoom {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, BDRoom::class.java,
                    // Especificamos el nombre de la base de datos.
                    "baseDeDatosBD"
                )
                    .allowMainThreadQueries()
                     //Debajo de esta linea incluiremos las migraciones
                    //.addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
            }
            return INSTANCE as BDRoom
        }

/*      DEFINIMOS LAS MIGRACIONES (CAMBIA EL NUMERO DE VERSION A LA ULTIMA MIGRACIÓN)

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE usuario ADD COLUMN descripcion TEXT")
            }
        }

        val MIGRATION_1_2: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS libro (" +
                        "idLibro INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "titulo TEXT NOT NULL," +
                        "genero TEXT NOT NULL," +
                        "usuario INTEGER NOT NULL," +
                        "FOREIGN KEY(usuario) REFERENCES usuario(id_usuario)" +
                        ")")
            }
        }
*/

    }
}
