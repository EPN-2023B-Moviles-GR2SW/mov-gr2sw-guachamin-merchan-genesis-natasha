package com.example.b2023gr2sw

import Album
import Artista
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class CrudAlbum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val indice = intent.getIntExtra("posicionItemSeleccionado", 0)
        setContentView(R.layout.formulario_crear_album)
        // Logica Buscar Entrenador


        val botonCrearArtista = findViewById<Button>(R.id.btn_crear_new_album)
        botonCrearArtista
            .setOnClickListener {
                val idAlbum = findViewById<EditText>(R.id.id_album)
                val nombreAlbum = findViewById<EditText>(R.id.id_nombre_album)
                val numeroCanciones = findViewById<EditText>(R.id.id_num_canciones)
                val precio = findViewById<EditText>(R.id.id_precio_album)
                BaseDatosMemoria.crearAlbum(
                    Album(
                        idAlbum.text.toString().toInt(),
                        nombreAlbum.text.toString(),
                        numeroCanciones.text.toString().toInt(),
                        precio.text.toString().toDouble()
                    ), indice
                )
                irActividad(ListaAlbumes::class.java)

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