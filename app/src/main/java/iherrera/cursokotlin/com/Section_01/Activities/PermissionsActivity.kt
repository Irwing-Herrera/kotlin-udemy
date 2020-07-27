package iherrera.cursokotlin.com.Section_01.Activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.goToActivityResult
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val REQUEST_CAMERA_PERMISSION: Int = 100
    private val REQUEST_CAMERA_PICTURE: Int = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        buttonPicture.setOnClickListener { _getPictureFromCameraAskingPermissions() }
    }

    private fun _getPictureFromCameraAskingPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Si no ha sido aceptado previamente (Para versiones desde 6.0 [API 23] en adelante)
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            // Si ha sido aceptado previamente (Para versiones inferiores a la 6.0 [API 23])
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CAMERA_PICTURE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                    goToActivityResult(MediaStore.ACTION_IMAGE_CAPTURE, REQUEST_CAMERA_PICTURE)
                } else {
                    // Permiso denegado
                    Toast.makeText(
                        this,
                        "You can´t take a picture if you don´t allow it",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CAMERA_PICTURE -> {
                // Comprobar si el resultado es bueno
                if (resultCode == Activity.RESULT_OK) {
                    // Obtenemos los extra del intent recibido por parametros
                    val extras = data!!.extras
                    // Formamos el bitmap a partir de los extra
                    val imageBitmap = extras!!.get("data") as Bitmap
                    // Cargamos la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitmap)
                } else {
                    // La foto no ha sido tomada
                    Toast.makeText(
                        this,
                        "Picture has failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            else -> {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}