package com.example.b2023gr2sw

import Album
import AlbumDAO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CrudAlbum : AppCompatActivity() {

    private lateinit var albumDAO: AlbumDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val indice = intent.getIntExtra("posicionItemSeleccionado", 0)
        setContentView(R.layout.formulario_crear_album)

        // Inicializa el AlbumDAO
        albumDAO = AlbumDAO(this)

        val botonCrearAlbum = findViewById<Button>(R.id.btn_crear_new_album)
        botonCrearAlbum.setOnClickListener {
            val idAlbum = findViewById<EditText>(R.id.id_album).text.toString().toInt()
            val nombreAlbum = findViewById<EditText>(R.id.id_nombre_album).text.toString()
            val numeroCanciones = findViewById<EditText>(R.id.id_num_canciones).text.toString().toInt()
            val precio = findViewById<EditText>(R.id.id_precio_album).text.toString().toDouble()

            val nuevoAlbum = Album(idAlbum, nombreAlbum, numeroCanciones, precio)

            // Utiliza el CRUD de AlbumDAO para crear un nuevo álbum
            albumDAO.insertarAlbum(nuevoAlbum)

            irActividad(ListaAlbumes::class.java)
        }
    }

    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}
