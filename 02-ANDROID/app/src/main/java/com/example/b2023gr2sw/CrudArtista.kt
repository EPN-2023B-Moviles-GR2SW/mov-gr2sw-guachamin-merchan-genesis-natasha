package com.example.b2023gr2sw

import Artista
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class CrudArtista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecrud_entrenador)
        // Logica Buscar Entrenador


        val botonCrearArtista = findViewById<Button>(R.id.btn_crear_artista)
        botonCrearArtista
            .setOnClickListener {
                val idArtista = findViewById<EditText>(R.id.input_id)
                val nombre = findViewById<EditText>(R.id.input_nombre)
                val fechaNacimiento = findViewById<EditText>(R.id.input_fechaNacimiento)
                val edad = findViewById<EditText>(R.id.input_edad)
                BaseDatosMemoria.arreglo.add(
                    Artista(
                        idArtista.text.toString().toInt(),
                        nombre.text.toString(),
                        fechaNacimiento.text.toString(),
                        edad.text.toString().toInt(),
                        ArrayList()
                    )
                )
                irActividad(MainActivity::class.java)

            }


    }

    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun mostrarSnackbar(texto: String) {
        Snackbar
            .make(
                findViewById(R.id.cl_sqlite), // view
                texto, // texto
                Snackbar.LENGTH_LONG // tiempo
            )
            .show()
    }
}