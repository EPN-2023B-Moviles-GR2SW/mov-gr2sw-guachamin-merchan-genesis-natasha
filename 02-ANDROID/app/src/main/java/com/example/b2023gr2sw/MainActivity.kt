
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

import androidx.appcompat.app.AppCompatActivity

import com.example.b2023gr2sw.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonCicloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonCicloVida.setOnClickListener{
            irActividad(ACicloVida::class.java)
        }

    }

    fun irActividad(clase:Class<*>){
        val intent = Intent(this,clase)
        startActivity(intent)
    }
}