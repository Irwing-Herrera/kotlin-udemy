package iherrera.cursokotlin.com.Section_01.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Activities.Intents.IntentExtraActivity
import iherrera.cursokotlin.com.Section_01.Models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonWithExtras.setOnClickListener { _goIntentExtras() }
        buttonWithFlags.setOnClickListener  { _goIntentFlags() }
        buttonWithObject.setOnClickListener { _goIntentObject() }
    }

    private fun _goIntentExtras() {
        val intent = Intent(this, IntentExtraActivity::class.java)
        intent.putExtra("name", "Irwing")
        intent.putExtra("lastName", "Herrera")
        intent.putExtra("age", 24)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun _goIntentFlags() {
        val intent = Intent(this, IntentExtraActivity::class.java)
        // intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // No guarda el activity en el stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Borra el stack completo
        startActivity(intent)
        // finish() // Destruye este activity evitando entrar al stack
    }

    private fun _goIntentObject() {
        val intent = Intent(this, IntentExtraActivity::class.java)
        val student =  Student("Allison", "Herrera", 23, true)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}