package iherrera.cursokotlin.com.Section_01.App

import android.app.Application
import iherrera.cursokotlin.com.Section_01.Others.MySharedPreferences

val PREFERENCES: MySharedPreferences by lazy { MyApp.prefs!! }

class MyApp : Application() {

    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}