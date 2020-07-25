package iherrera.cursokotlin.com

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import iherrera.cursokotlin.com.Section_01.Activities.ClickEventsActivity
import iherrera.cursokotlin.com.Section_01.Activities.KotlinAndroidExtensionsActivity
import iherrera.cursokotlin.com.Section_01.Activities.LifeCycleEventsActivity
import iherrera.cursokotlin.com.Section_01.Activities.ToastAndSnackBarActivity

class MainActivity : AppCompatActivity() {

    private var _exitEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToastAndSnackBar = findViewById<Button>(R.id.buttonToastAndSnackBar)
        btnToastAndSnackBar.setOnClickListener { openActivity<ToastAndSnackBarActivity>(this) }

        val btnLifeCycleEvents = findViewById<Button>(R.id.buttonLifeCycleEvents)
        btnLifeCycleEvents.setOnClickListener { openActivity<LifeCycleEventsActivity>(this) }

        val btnClickEvents = findViewById<Button>(R.id.buttonToClickEvents)
        btnClickEvents.setOnClickListener { openActivity<ClickEventsActivity>(this) }

        val btnKotlinAndroidExtensions = findViewById<Button>(R.id.buttonToKotlinAndroidExtensions)
        btnKotlinAndroidExtensions.setOnClickListener { openActivity<KotlinAndroidExtensionsActivity>(this) }
    }

    private inline fun <reified T> openActivity(context: Context) {
        startActivity(Intent(context, T::class.java))
    }

    override fun onBackPressed() {
        if (_exitEnabled)
            super.onBackPressed()

        _exitEnabled = true
        Toast.makeText(this, "Click back again to exit this screen", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ _exitEnabled = false }, 2000)
    }
}