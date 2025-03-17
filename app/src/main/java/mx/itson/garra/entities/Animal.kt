package mx.itson.garra.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.garra.persistence.GarraDB

class Animal {

    var id = 0
    var nombre : String = ""
    var especie : String = ""
    var habilidades : String = ""

    constructor()

    constructor(id: Int, nombre : String, especie : String, habilidades : String){
        this.id = id
        this.nombre = nombre
        this.especie = especie
        this.habilidades = habilidades
    }

    fun get(context: Context) : List<Animal>{
        var animales : MutableList<Animal> = ArrayList()
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.readableDatabase

            val result = dataBase.rawQuery("SELECT id, nombre, especie, habilidades FROM Animal", null)
            while(result.moveToNext()) {
                val animal = Animal(result.getInt(0), result.getString(1), result.getString(2), result.getString(3))
                animales.add(animal)
            }
        } catch(ex: Exception){
            Log.e("Error obteniendo registros", ex.message.toString())
        }
        return animales
    }

    fun save(context : Context, nombre : String, especie : String, habilidades : String){
        try {
            val garraDB = GarraDB(context, "GarraDB", null, 1)
            val dataBase : SQLiteDatabase = garraDB.writableDatabase

            val values  = ContentValues()
            values.put("nombre", nombre)
            values.put("especie", especie)
            values.put("habilidades", habilidades)

            dataBase.insert("Animal", null, values)
        } catch(ex: Exception){
            Log.e("Error al guardar un registro de animal", ex.message.toString())
        }
    }
}