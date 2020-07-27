package iherrera.cursokotlin.com.Section_01.Others

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (context: Context) {

    // Nombre del fichero de shared preferences
    private val FILENAME: String = "mis preferencias"
    // Instancia de ese fichero
    private val PREFS: SharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

    // Por cada una de las variables que vamos a guardaren nuestro fichero shared preferences
    var name
        get() = PREFS.getString("name", "")
        set(value) = PREFS.edit().putString("name", value).apply()

    var age
        get() = PREFS.getInt("age", -1)
        set(value) = PREFS.edit().putInt("age", value).apply()

}