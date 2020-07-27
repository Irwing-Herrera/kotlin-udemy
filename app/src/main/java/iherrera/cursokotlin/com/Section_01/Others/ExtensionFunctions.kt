package iherrera.cursokotlin.com.Section_01.Others

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import iherrera.cursokotlin.com.R

fun Int.isNatural() = this >= 0

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Activity.toast(resorceId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, resorceId, duration).show()

fun Activity.snackBar(
    message: CharSequence, view: View? = findViewById(R.id.container),
    duration: Int = Snackbar.LENGTH_SHORT, action: String? = null,
    actionEvent: (v: View) -> Unit = {}
) {

    if (view != null) {
        val snackbar = Snackbar.make(view, message, duration)
        if (!action.isNullOrEmpty()) {
            snackbar.setAction(action, actionEvent)
        }
        snackbar.show()
    }
}

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)

fun ImageView.loadByUrl(url: String) = Picasso.get().load(url).into(this)

inline fun <reified T: Activity> Activity.openActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}

fun Activity.goToActivityResult(action: String, requestCode: Int, init: Intent.() -> Unit = {}) {
    val intent = Intent(action)
    intent.init()
    startActivityForResult(intent, requestCode)
}