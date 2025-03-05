package mx.itson.garra.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.garra.persistence.GarraDB

class Animal {

    var id = 0
    var nombre : String = ""

    constructor()

    constructor(id: Int, nombre : String){
        this.id = id
        this.nombre = nombre
    }

    fun get(context: Context) : List<Animal>{
        var animales : MutableList<Animal> = ArrayList()
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.readableDatabase

            val result = dataBase.rawQuery("SELECT id, nombre FROM Animal", null)
            while(result.moveToNext()) {
                val animal = Animal(result.getInt(0), result.getString(1))
                animales.add(animal)
            }
        } catch(ex: Exception){
            Log.e("Error obteniendo registros", ex.message.toString())
        }
        return animales
    }

    fun save(context : Context, nombre : String){
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.writableDatabase

            val values  = ContentValues()
            values.put("nombre", nombre)

            dataBase.insert("Animal", null, values)
        } catch(ex: Exception){
            Log.e("Error al guardar un registro de animal", ex.message.toString())
        }
    }
}