import java.util.*

fun main() {

    //TIPOS DE VARIABLES
    /*  INMUTABLES (No se reasignan)
        * val
        MUTABLES (Son reasignables)
        * var
     */
    val inmutable: String = "Génesis";
    // inmutable = "Natasha"

    var mutable: String = "Génesis";
    mutable = "Natasha"

    println(inmutable)
    println(mutable + " es mi segundo nombre")

    //Duck Typing
    var ejemploNombre = "Génesis Guachamín"
    val edadEjemplo: Int = 24
    ejemploNombre.trim()
    //ejemploNombre = edadEjemplo

    //VARIABLES PRIMITIVAS
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true

    //CLASES JAVA
    val fechaNacimiento: Date = Date()

    //SWITCH
    val estadoCivilWhen = "C"
    when (estadoCivilWhen) {
        "C" -> {
            println("Casado")
        }

        "S" -> {
            println("Soltero")
        }

        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueto = if (esSoltero) "Si" else "No"

    println(coqueto)

    //Llamada a la función
    calcularSueldo(10.00)
    calcularSueldo(10.00, 15.00,20.00)
    calcularSueldo(10.00, bonoEspecial = 30.00)
    calcularSueldo(bonoEspecial = 10.00, sueldo = 10.00)




}

//Clase abstracta

abstract class NumerosJava{
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    )
    {
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

//PARA KOTLIN

abstract class Numeros( //CONSTRUCTOR PRIMARIO
    protected val numeroUno: Int,
    protected val numeroDos: Int
){
    init{ //CONSTRUCTOR SECUNDARIO
        this.numeroUno; this.numeroDos //Usar this es opcional
        numeroUno; numeroDos //Se puede sin el this
        println("Inicializando")
    }
}










//void -> Unit

fun imprimirNombre(nombre: String): Unit{
    println("Nombre : ${nombre}")
}

fun calcularSueldo(
    sueldo:Double,
    tasa:Double = 12.00,
    bonoEspecial: Double? = null
    ):Double {
    if (bonoEspecial == null){
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa) + bonoEspecial
    }
}








