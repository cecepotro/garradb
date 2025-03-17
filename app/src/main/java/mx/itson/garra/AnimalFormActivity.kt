package mx.itson.garra

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.garra.entities.Animal

class AnimalFormActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var nombre : EditText
    lateinit var especie : EditText
    lateinit var habilidades : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnSave =  findViewById<Button>(R.id.btn_save)
        btnSave.setOnClickListener(this)

        nombre = findViewById(R.id.txt_name)
        especie = findViewById(R.id.txt_especie)
        habilidades = findViewById(R.id.txt_skills)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_save -> {
                val txtNombre = nombre.text.toString()
                val txtEspecie = especie.text.toString()
                val txtHabilidades = habilidades.text.toString()

                Animal().save(this, txtNombre, txtEspecie, txtHabilidades)
            }

        }
    }
}