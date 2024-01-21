import java.util.*
import kotlin.collections.ArrayList

class Artista(
    idArtista: Int,
    nombreArtista: String,
    fechaNacimiento: String,
    edad: Int,
    albumes: ArrayList<Album>
) {
    val idArtista: Int
    val nombreArtista: String
    val fechaNacimiento: String
    val edad: Int
    val albumes: ArrayList<Album>


    init {
        this.idArtista = idArtista
        this.nombreArtista = nombreArtista
        this.fechaNacimiento = fechaNacimiento
        this.edad = edad
        this.albumes = albumes
    }

    override fun toString(): String {
        return "$nombreArtista"
    }

    fun obtenerTodosLosAlbums(): ArrayList<Album> {
        return albumes
    }
}
