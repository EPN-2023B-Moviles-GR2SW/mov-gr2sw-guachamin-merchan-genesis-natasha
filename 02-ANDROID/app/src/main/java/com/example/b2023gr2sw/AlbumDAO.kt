import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.b2023gr2sw.SQLiteConexion

class AlbumDAO(context: Context) {

    private val db: SQLiteDatabase = SQLiteConexion(context).writableDatabase

    fun insertarAlbum(album: Album) {
        val values = ContentValues().apply {
            put(SQLiteConexion.COLUMNA_NOMBRE_ALBUM, album.nombreAlbum)
            put(SQLiteConexion.COLUMNA_NUMERO_CANCIONES, album.numeroCanciones)
            put(SQLiteConexion.COLUMNA_PRECIO, album.precio)
        }
        db.insert(SQLiteConexion.TABLA_ALBUMES, null, values)
    }

    @SuppressLint("Range")
    fun obtenerAlbumes(): List<Album> {
        val listaAlbumes = mutableListOf<Album>()
        val cursor: Cursor = db.query(
            SQLiteConexion.TABLA_ALBUMES,
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {
            val idAlbum = cursor.getInt(cursor.getColumnIndex(SQLiteConexion.COLUMNA_ID_ALBUM))
            val nombreAlbum =
                cursor.getString(cursor.getColumnIndex(SQLiteConexion.COLUMNA_NOMBRE_ALBUM))
            val numeroCanciones =
                cursor.getInt(cursor.getColumnIndex(SQLiteConexion.COLUMNA_NUMERO_CANCIONES))
            val precio = cursor.getDouble(cursor.getColumnIndex(SQLiteConexion.COLUMNA_PRECIO))

            val album = Album(idAlbum, nombreAlbum, numeroCanciones, precio)
            listaAlbumes.add(album)
        }
        cursor.close()
        return listaAlbumes
    }

    fun actualizarAlbum(album: Album) {
        val values = ContentValues().apply {
            put(SQLiteConexion.COLUMNA_NOMBRE_ALBUM, album.nombreAlbum)
            put(SQLiteConexion.COLUMNA_NUMERO_CANCIONES, album.numeroCanciones)
            put(SQLiteConexion.COLUMNA_PRECIO, album.precio)
        }
        db.update(
            SQLiteConexion.TABLA_ALBUMES,
            values,
            "${SQLiteConexion.COLUMNA_ID_ALBUM} = ?",
            arrayOf(album.idAlbum.toString())
        )
    }

    fun eliminarAlbum(idAlbum: Int) {
        db.delete(
            SQLiteConexion.TABLA_ALBUMES,
            "${SQLiteConexion.COLUMNA_ID_ALBUM} = ?",
            arrayOf(idAlbum.toString())
        )
    }
}
