import java.util.*

class Album(
    nombreAlbum: String,
    numeroCanciones: Int,
    precio: Double,
    fechaLanzamiento: String,
    esFisico: Boolean
) {
    val nombreAlbum: String
    val numeroCanciones: Int
    val precio: Double
    val fechaLanzamiento: String
    val esFisico: Boolean

    init {
        this.nombreAlbum =  nombreAlbum
        this.numeroCanciones = numeroCanciones
        this.precio = precio
        this.fechaLanzamiento = fechaLanzamiento
        this.esFisico = esFisico
    }

    override fun toString(): String {
        return "$nombreAlbum, $numeroCanciones,$precio,$fechaLanzamiento,$esFisico"
    }

}
