import java.util.*

class Album(
    idAlbum: Int,
    nombreAlbum: String,
    numeroCanciones: Int,
    precio: Double
) {
    val idAlbum: Int
    val nombreAlbum: String
    val numeroCanciones: Int
    val precio: Double


    init {
        this.idAlbum = idAlbum
        this.nombreAlbum =  nombreAlbum
        this.numeroCanciones = numeroCanciones
        this.precio = precio
    }

    override fun toString(): String {
        return "$nombreAlbum"
    }

}
