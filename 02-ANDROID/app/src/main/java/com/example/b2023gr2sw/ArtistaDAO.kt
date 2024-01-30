import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.b2023gr2sw.SQLiteConexion

class ArtistaDAO(context: Context) {

    private val db: SQLiteDatabase = SQLiteConexion(context).writableDatabase

    fun insertarArtista(artista: Artista) {
        val values = ContentValues().apply {
            put(SQLiteConexion.COLUMNA_NOMBRE_ARTISTA, artista.nombreArtista)
            put(SQLiteConexion.COLUMNA_FECHA_NACIMIENTO, artista.fechaNacimiento)
            put(SQLiteConexion.COLUMNA_EDAD, artista.edad)
        }
        db.insert(SQLiteConexion.TABLA_ARTISTAS, null, values)
    }

    @SuppressLint("Range")
    fun obtenerArtistas(): List<Artista> {
        val listaArtistas = mutableListOf<Artista>()
        val cursor: Cursor = db.query(
            SQLiteConexion.TABLA_ARTISTAS,
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {
            val idArtista = cursor.getInt(cursor.getColumnIndex(SQLiteConexion.COLUMNA_ID_ARTISTA))
            val nombreArtista =
                cursor.getString(cursor.getColumnIndex(SQLiteConexion.COLUMNA_NOMBRE_ARTISTA))
            val fechaNacimiento =
                cursor.getString(cursor.getColumnIndex(SQLiteConexion.COLUMNA_FECHA_NACIMIENTO))
            val edad = cursor.getInt(cursor.getColumnIndex(SQLiteConexion.COLUMNA_EDAD))

            val artista = Artista(idArtista, nombreArtista, fechaNacimiento, edad)
            listaArtistas.add(artista)
        }
        cursor.close()
        return listaArtistas
    }

    fun actualizarArtista(artista: Artista) {
        val values = ContentValues().apply {
            put(SQLiteConexion.COLUMNA_NOMBRE_ARTISTA, artista.nombreArtista)
            put(SQLiteConexion.COLUMNA_FECHA_NACIMIENTO, artista.fechaNacimiento)
            put(SQLiteConexion.COLUMNA_EDAD, artista.edad)
        }
        db.update(
            SQLiteConexion.TABLA_ARTISTAS,
            values,
            "${SQLiteConexion.COLUMNA_ID_ARTISTA} = ?",
            arrayOf(artista.idArtista.toString())
        )
    }

    fun eliminarArtista(idArtista: Int) {
        db.delete(
            SQLiteConexion.TABLA_ARTISTAS,
            "${SQLiteConexion.COLUMNA_ID_ARTISTA} = ?",
            arrayOf(idArtista.toString())
        )
    }

}