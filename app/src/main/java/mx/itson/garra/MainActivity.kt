package mx.itson.garra

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.garra.entities.Animal

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNew = findViewById<Button>(R.id.btn_new)
        btnNew.setOnClickListener(this)

        val btnList = findViewById<Button>(R.id.btn_list)
        btnList.setOnClickListener(this)
        //Animal().save(this, "León leoncio")
        //Animal().get(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_new -> {
                val intentFormAnimal = Intent(this, AnimalFormActivity::class.java)
                startActivity(intentFormAnimal)
            }
            R.id.btn_list -> {
                val intentListAnimal = Intent(this, AnimalListActivity::class.java)
                startActivity(intentListAnimal)
            }
        }
    }
}