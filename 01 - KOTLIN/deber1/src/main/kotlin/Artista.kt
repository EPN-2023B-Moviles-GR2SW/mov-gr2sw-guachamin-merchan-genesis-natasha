import java.util.*
import kotlin.collections.ArrayList

class Artista(
    nombreArtista: String,
    fechaNacimiento: String,
    edad: Int,
    estaVivo: Boolean,
    estatura: Double,
    albumes: ArrayList<Album>
) {
    val nombreArtista: String
    val fechaNacimiento: String
    val edad: Int
    val estaVivo: Boolean
    val estatura: Double

    init {
        this.nombreArtista = nombreArtista
        this.fechaNacimiento = fechaNacimiento
        this.edad = edad
        this.estaVivo = estaVivo
        this.estatura = estatura
    }

    override fun toString(): String {
        return "$nombreArtista,$fechaNacimiento,$edad,$estaVivo,$estatura"
    }
}
