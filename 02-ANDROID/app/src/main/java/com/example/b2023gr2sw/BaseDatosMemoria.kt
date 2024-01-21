package com.example.b2023gr2sw

import Album
import Artista

class BaseDatosMemoria {
    companion object {
        val arreglo = arrayListOf<Artista>()

        init {
            arreglo.add(
                Artista(
                    1,
                    "Pedro Infante",
                    "18 de noviembre de 1917",
                    39,
                    arrayListOf(
                        Album(
                            idAlbum = 1,
                            nombreAlbum = "Só Você",
                            numeroCanciones = 12,
                            precio = 29.90
                        ),
                        Album(
                            idAlbum = 2,
                            nombreAlbum = "Amame",
                            numeroCanciones = 12,
                            precio = 29.90
                        ),

                        Album(
                            idAlbum = 2,
                            nombreAlbum = "Cuando termina el placer",
                            numeroCanciones = 12,
                            precio = 29.90
                        )
                    )
                )
            )
            arreglo.add(
                Artista(
                    4,
                    "Adele",
                    "5 de mayo de 1988",
                    34,
                    arrayListOf(
                        Album(
                            idAlbum = 10,
                            nombreAlbum = "19",
                            numeroCanciones = 12,
                            precio = 26.50
                        ),
                        Album(
                            idAlbum = 11,
                            nombreAlbum = "21",
                            numeroCanciones = 11,
                            precio = 30.20
                        ),
                        Album(
                            idAlbum = 12,
                            nombreAlbum = "25",
                            numeroCanciones = 13,
                            precio = 32.80
                        )
                    )
                )
            )
            arreglo.add(
                Artista(
                    3,
                    "Michael Jackson",
                    "29 de agosto de 1958",
                    50,
                    arrayListOf(
                        Album(
                            idAlbum = 7,
                            nombreAlbum = "Thriller",
                            numeroCanciones = 9,
                            precio = 30.00
                        ),
                        Album(
                            idAlbum = 8,
                            nombreAlbum = "Bad",
                            numeroCanciones = 11,
                            precio = 28.50
                        ),
                        Album(
                            idAlbum = 9,
                            nombreAlbum = "Dangerous",
                            numeroCanciones = 14,
                            precio = 35.25
                        )
                    )
                )
            )


        }

        fun obtenerAlbums(indice: Int): ArrayList<Album> {
            return arreglo.get(indice).obtenerTodosLosAlbums()
        }

        fun crearAlbum(album: Album, indice: Int) {
            arreglo.get(indice).agregarAlbum(album)
        }

        fun eliminarAlbum(posicionItemSeleccionado: Int, indice: Int) {
            arreglo.get(indice).eliminarAlbum(posicionItemSeleccionado)
        }


    }


}

