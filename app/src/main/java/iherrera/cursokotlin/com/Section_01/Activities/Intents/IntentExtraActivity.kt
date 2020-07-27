package iherrera.cursokotlin.com.Section_01.Activities.Intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Activities.IntentsActivity
import iherrera.cursokotlin.com.Section_01.Models.Student
import kotlinx.android.synthetic.main.activity_intent_extra.*

class IntentExtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extra)

        buttonBack.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }

        val isExtraSet = _setIntentExtraFromPreviousActivity()
        val isParcelableSet = _setParcelableExtraFromPreviousActivity()

        if (!isExtraSet && !isParcelableSet)
            switch1.visibility = View.INVISIBLE

    }

    private fun _setIntentExtraFromPreviousActivity() : Boolean {
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age", -1)
        val developer: Boolean = intent.getBooleanExtra("developer", false)

        if (name != null && lastName != null && age >= 0) {
            textViewFirstName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            switch1.isChecked = developer

            return true
        }

        return false
    }

    private fun _setParcelableExtraFromPreviousActivity() : Boolean {
        val student = intent.getParcelableExtra<Student>("student")
        student?.let {
            switch1.visibility = View.VISIBLE

            textViewFirstName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            switch1.isChecked = student.isDeveloper

            return true
        }
        return false
    }
}