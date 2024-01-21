package com.example.b2023gr2sw

import Album
import Artista
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ListaAlbumes : AppCompatActivity() {

    var posicionItemSeleccionado = -1

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val posicion = info.position
        posicionItemSeleccionado = posicion
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Use the correct ID for the ListView in your layout
        val listView = findViewById<ListView>(R.id.lv_albumes)
        val adaptador = listView.adapter as ArrayAdapter<Artista>

        return when (item.itemId) {
            R.id.mi_editar -> {
                mostrarSnackbar("${posicionItemSeleccionado}")
                return true
            }

            R.id.mi_eliminar -> {
                mostrarSnackbar("${posicionItemSeleccionado}")
                abrirDialogo(adaptador)
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_albumes)

        val indice = intent.getIntExtra("posicionItemSeleccionado", 0)
        val arreglo = BaseDatosMemoria.obtenerAlbums(indice)

        val listView = findViewById<ListView>(R.id.lv_albumes)
        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo
        )
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()

        val botonAnadirListView = findViewById<Button>(R.id.btn_crear_album)
        botonAnadirListView.setOnClickListener {
            irActividadConParametros(CrudAlbum::class.java)
        }

        // Use the correct ID for the ListView in your layout
        registerForContextMenu(listView)
    }

    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun irActividadConParametros(clase: Class<*>) {
        val indice = intent.getIntExtra("posicionItemSeleccionado", 0)
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("posicionItemSeleccionado", indice)
        startActivity(intentExplicito)
    }

    fun abrirDialogo(adaptador: ArrayAdapter<Artista>) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar")
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener { dialog, which ->
                if (posicionItemSeleccionado != -1 && posicionItemSeleccionado < adaptador.count) {
                    adaptador.remove(adaptador.getItem(posicionItemSeleccionado))
                    adaptador.notifyDataSetChanged()
                    mostrarSnackbar("Eliminar aceptado")
                }
            }
        )
        builder.setNegativeButton(
            "Cancelar",
            null
        )

        val dialogo = builder.create()
        dialogo.show()
    }

    fun mostrarSnackbar(texto: String) {
        val snack = Snackbar.make(
            findViewById(R.id.lv_albumes),
            texto, Snackbar.LENGTH_LONG
        )
        snack.show()
    }
}
