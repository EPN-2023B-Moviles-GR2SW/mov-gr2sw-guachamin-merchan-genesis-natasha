package com.example.b2023gr2sw

import Artista

class BaseDatosMemoria {
    companion object {
        val arregloArtistas = arrayListOf<Artista>()

        init {
            arregloArtistas.add(
                Artista(1, "Pedro Infante", "18 de noviembre de 1917", 39, false, 1.75, ArrayList())
            )
            arregloArtistas.add(
                Artista(2, "Amy Winehouse", "18 de noviembre de 1917", 39, false, 1.75, ArrayList())
            )
            arregloArtistas.add(
                Artista(3, "Alexandre Pires", "18 de noviembre de 1917", 39, false, 1.75, ArrayList())
            )
        }
    }
}

