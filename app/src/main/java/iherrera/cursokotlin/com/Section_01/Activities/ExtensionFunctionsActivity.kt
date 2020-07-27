package iherrera.cursokotlin.com.Section_01.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iherrera.cursokotlin.com.MainActivity
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.loadByUrl
import iherrera.cursokotlin.com.Section_01.Others.openActivity
import iherrera.cursokotlin.com.Section_01.Others.snackBar
import iherrera.cursokotlin.com.Section_01.Others.toast
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        buttonToast.setOnClickListener { toast("Hola")  }
        buttonSnackbar.setOnClickListener { snackBar("snackbar", action = "Undo") { toast("Undo!!")} }
        buttonLoadByUrl.setOnClickListener { imageViewLoadedByUrl.loadByUrl("https://images.pexels.com/photos/825947/pexels-photo-825947.jpeg") }
        buttonGoToActivity.setOnClickListener { openActivity<MainActivity> { putExtra("name", "" ) } }
    }
}