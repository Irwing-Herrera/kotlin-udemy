package iherrera.cursokotlin.com

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import iherrera.cursokotlin.com.Section_01.Activities.ToastAndSnackBarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToastAndSnackBar = findViewById<Button>(R.id.buttonToastAndSnackBar)

        btnToastAndSnackBar.setOnClickListener(View.OnClickListener {
            openActivity<ToastAndSnackBarActivity>(this)
        })
    }

    private inline fun <reified T> openActivity(context: Context) {
        startActivity(Intent(context, T::class.java))
    }
}