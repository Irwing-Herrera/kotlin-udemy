package iherrera.cursokotlin.com

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import iherrera.cursokotlin.com.Section_01.Activities.*
import iherrera.cursokotlin.com.Section_01.Others.LifeCycleEventsActivity
import iherrera.cursokotlin.com.Section_01.Others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    private var _exitEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarToLoad(toolbar as Toolbar)
        //enableHomeDisplay(true)

        val btnToastAndSnackBar = findViewById<Button>(R.id.buttonToastAndSnackBar)
        btnToastAndSnackBar.setOnClickListener { openActivity<ToastAndSnackBarActivity>(this) }

        val btnLifeCycleEvents = findViewById<Button>(R.id.buttonLifeCycleEvents)
        btnLifeCycleEvents.setOnClickListener { openActivity<LifeCycleEventsActivity>(this) }

        val btnClickEvents = findViewById<Button>(R.id.buttonToClickEvents)
        btnClickEvents.setOnClickListener { openActivity<ClickEventsActivity>(this) }

        val btnKotlinAndroidExtensions = findViewById<Button>(R.id.buttonToKotlinAndroidExtensions)
        btnKotlinAndroidExtensions.setOnClickListener { openActivity<KotlinAndroidExtensionsActivity>(this) }

        val btnToListView = findViewById<Button>(R.id.buttonToListView)
        btnToListView.setOnClickListener { openActivity<ListViewActivity>(this) }

        val btnToIntents = findViewById<Button>(R.id.buttonToIntents)
        btnToIntents.setOnClickListener { openActivity<IntentsActivity>(this) }

        buttonToPicasso.setOnClickListener { openActivity<PicassoActivity>(this) }

        buttonToPermissions.setOnClickListener { openActivity<PermissionsActivity>(this) }
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