package mx.itson.garra

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.garra.adapters.AnimalAdapter
import mx.itson.garra.entities.Animal

class AnimalListActivity : AppCompatActivity() {

    var listAnimales : ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listAnimales = findViewById(R.id.list_animales)

        val animales : List<Animal> = Animal().get(this)
        listAnimales?.adapter = AnimalAdapter(this, animales)
    }
}