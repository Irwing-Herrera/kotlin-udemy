package iherrera.cursokotlin.com.Section_01.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import iherrera.cursokotlin.com.R

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        val btnClickInLine = findViewById<Button>(R.id.buttonClickInLine)
        val btnMultiple1 = findViewById<Button>(R.id.buttonMultipleButtons1)
        val btnMultiple2 = findViewById<Button>(R.id.buttonMultipleButtons2)
        val btnMultiple3 = findViewById<Button>(R.id.buttonMultipleButtons3)

        btnClickInLine.setOnLongClickListener(this)
        btnMultiple1.setOnLongClickListener(this)
        btnMultiple2.setOnLongClickListener(this)
        btnMultiple3.setOnLongClickListener(this)

    }

    fun xmlClick(view: View) {
        Toast.makeText(this, "Click by XML", Toast.LENGTH_SHORT).show()
    }

    private fun _clickInLine() = Toast.makeText(this, "Click In Line", Toast.LENGTH_SHORT).show()

    override fun onLongClick(view: View): Boolean {
        when(view.id) {
            R.id.buttonMultipleButtons1 -> Toast.makeText(this, "Click Multi 1", Toast.LENGTH_SHORT).show()
            R.id.buttonMultipleButtons2 -> Toast.makeText(this, "Click Multi 2", Toast.LENGTH_SHORT).show()
            R.id.buttonMultipleButtons3 -> Toast.makeText(this, "Click Multi 3", Toast.LENGTH_SHORT).show()
            R.id.buttonClickInLine -> _clickInLine()
        }
        return true
    }
}