package com.example.b2023gr2sw

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador.add(
                BEntrenador(1, "Génesis", "abcd")
            )
            arregloBEntrenador.add(
                BEntrenador(2, "Natasha", "abcd")
            )
            arregloBEntrenador.add(
                BEntrenador(3, "Naty", "abcd")
            )
        }
    }
}

