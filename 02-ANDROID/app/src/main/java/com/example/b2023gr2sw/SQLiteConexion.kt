package com.example.b2023gr2sw

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class SQLiteConexion(context: Context) :
    SQLiteOpenHelper(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS) {
    companion object {
        const val NOMBRE_BASE_DATOS = "musica.db"
        const val VERSION_BASE_DATOS = 1

        // Tabla de Artistas
        const val TABLA_ARTISTAS = "artistas"
        const val COLUMNA_ID_ARTISTA = "id_artista"
        const val COLUMNA_NOMBRE_ARTISTA = "nombre_artista"
        const val COLUMNA_FECHA_NACIMIENTO = "fecha_nacimiento"
        const val COLUMNA_EDAD = "edad"
        const val COLUMNA_ESTATURA = "estatura"

        // Tabla de Álbumes
        const val TABLA_ALBUMES = "albumes"
        const val COLUMNA_ID_ALBUM = "id_album"
        const val COLUMNA_NOMBRE_ALBUM = "nombre_album"
        const val COLUMNA_NUMERO_CANCIONES = "numero_canciones"
        const val COLUMNA_PRECIO = "precio"
        const val COLUMNA_ID_ARTISTA_FK = "id_artista_fk"

        const val CREAR_TABLA_ARTISTAS =
            "CREATE TABLE $TABLA_ARTISTAS (" +
                    "$COLUMNA_ID_ARTISTA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMNA_NOMBRE_ARTISTA TEXT, " +
                    "$COLUMNA_FECHA_NACIMIENTO TEXT, " +
                    "$COLUMNA_EDAD INTEGER)"


        const val CREAR_TABLA_ALBUMES =
            "CREATE TABLE $TABLA_ALBUMES (" +
                    "$COLUMNA_ID_ALBUM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMNA_NOMBRE_ALBUM TEXT, " +
                    "$COLUMNA_NUMERO_CANCIONES INTEGER, " +
                    "$COLUMNA_PRECIO REAL, " +
                    "$COLUMNA_ID_ARTISTA_FK INTEGER, " +
                    "FOREIGN KEY($COLUMNA_ID_ARTISTA_FK) REFERENCES $TABLA_ARTISTAS($COLUMNA_ID_ARTISTA));"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREAR_TABLA_ARTISTAS)
        db?.execSQL(CREAR_TABLA_ALBUMES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLA_ARTISTAS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLA_ALBUMES")
        onCreate(db)
    }
}
