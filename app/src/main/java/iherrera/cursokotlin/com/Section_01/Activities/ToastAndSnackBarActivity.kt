package iherrera.cursokotlin.com.Section_01.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import iherrera.cursokotlin.com.R

class ToastAndSnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toas_and_snack_bar)

        val layout = findViewById<ConstraintLayout>(R.id.layoutConstraint)

        val btnToast    = findViewById<Button>(R.id.buttonToast)
        val btnSnackbar = findViewById<Button>(R.id.buttonSnackbar)

        btnToast.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Hellow from the Toast", Toast.LENGTH_SHORT).show()
        })

        btnSnackbar.setOnClickListener(View.OnClickListener {
            Snackbar.make(layout, "Hello from the SnackBar", Snackbar.LENGTH_LONG).setAction("UNDO") {
                Snackbar.make(layout, "Email has been restored", Snackbar.LENGTH_LONG).show()
            }.show()
        })
    }
}