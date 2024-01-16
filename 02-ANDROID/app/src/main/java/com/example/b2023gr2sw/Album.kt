import java.util.*

class Album(
    idAlbum: Int,
    nombreAlbum: String,
    numeroCanciones: Int,
    precio: Double,
    fechaLanzamiento: String,
    esFisico: Boolean
) {
    val idAlbum: Int
    val nombreAlbum: String
    val numeroCanciones: Int
    val precio: Double
    val fechaLanzamiento: String
    val esFisico: Boolean

    init {
        this.idAlbum = idAlbum
        this.nombreAlbum =  nombreAlbum
        this.numeroCanciones = numeroCanciones
        this.precio = precio
        this.fechaLanzamiento = fechaLanzamiento
        this.esFisico = esFisico
    }

    override fun toString(): String {
        return "$nombreAlbum"
    }

}
