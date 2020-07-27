package iherrera.cursokotlin.com.Section_01.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.App.PREFERENCES
import kotlinx.android.synthetic.main.activity_shred_preferences.*

class ShredPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shred_preferences)

        buttonSave.setOnClickListener { _setValueSharedPreferences(); _cleanEditTexts(); }
        _getValueSharedPreferences()
    }

    private fun _getValueSharedPreferences() {
        if (PREFERENCES.name!!.isNotEmpty() && PREFERENCES.age >= 0) {
            textViewInformation.text = "Welcome ${PREFERENCES.name}, ytour age is ${PREFERENCES.age}"
        } else
            textViewInformation.text = "Welcome, Please save your name and year age"
    }

    private fun _setValueSharedPreferences() {
        if (editTextName.text.toString().isNotEmpty() && editTexttAge.text.toString().isNotEmpty()) {
            PREFERENCES.name = editTextName.text.toString()
            PREFERENCES.age  = editTexttAge.text.toString().toInt()
            Toast.makeText(this, "Values have been saved successfully", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, "Please fill the name and age before saving", Toast.LENGTH_SHORT).show()
    }

    private fun _cleanEditTexts() {
        editTextName.text.clear()
        editTexttAge.text.clear()
    }
}