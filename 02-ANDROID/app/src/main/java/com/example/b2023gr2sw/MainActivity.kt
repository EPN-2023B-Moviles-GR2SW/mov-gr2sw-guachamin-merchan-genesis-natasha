package com.example.b2023gr2sw

import Artista
import ArtistaDAO
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

class MainActivity : AppCompatActivity() {
    private lateinit var artistaDAO: ArtistaDAO
    private lateinit var adaptador: ArrayAdapter<Artista>
    private var posicionItemSeleccionado = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)

        // Inicializa el ArtistaDAO
        artistaDAO = ArtistaDAO(this)

        val listView = findViewById<ListView>(R.id.lv_list_view)
        adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            artistaDAO.obtenerArtistas()
        )
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()

        val botonAnadirListView = findViewById<Button>(R.id.btn_anadir_list_view)
        botonAnadirListView.setOnClickListener {
            irActividad(CrudArtista::class.java)
        }
        registerForContextMenu(listView)
    }

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
        return when (item.itemId) {
            R.id.mi_editar -> {
                mostrarSnackbar("${posicionItemSeleccionado}")
                return true
            }

            R.id.mi_eliminar -> {
                mostrarSnackbar("${posicionItemSeleccionado}")
                abrirDialogo()
                return true
            }

            R.id.mi_ver -> {
                irActividadConParametros(ListaAlbumes::class.java)
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun abrirDialogo() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar")
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener { dialog, which ->
                if (posicionItemSeleccionado != -1 && posicionItemSeleccionado < adaptador.count) {
                    val artista = adaptador.getItem(posicionItemSeleccionado)
                    artista?.let {
                        artistaDAO.eliminarArtista(it.idArtista)
                        adaptador.remove(it)
                        adaptador.notifyDataSetChanged()
                        mostrarSnackbar("Eliminar aceptado")
                    }
                }
            }
        )
        builder.setNegativeButton("Cancelar", null)
        val opciones = resources.getStringArray(R.array.string_array_opciones_dialogo)
        val seleccionPrevia = booleanArrayOf(true, false, false)
        builder.setMultiChoiceItems(
            opciones,
            seleccionPrevia
        ) { dialog, which, isChecked ->
            mostrarSnackbar("Dio clic en el item $which")
        }
        val dialogo = builder.create()
        dialogo.show()
    }

    fun mostrarSnackbar(texto: String) {
        val snack = Snackbar.make(
            findViewById(R.id.lv_list_view),
            texto, Snackbar.LENGTH_LONG
        )
        snack.show()
    }

    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun irActividadConParametros(clase: Class<*>) {
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("posicionItemSeleccionado", posicionItemSeleccionado)
        startActivity(intentExplicito)
    }
}
