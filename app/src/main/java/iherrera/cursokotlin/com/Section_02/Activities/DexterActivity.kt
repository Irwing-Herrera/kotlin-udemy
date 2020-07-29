package iherrera.cursokotlin.com.Section_02.Activities

import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.ToolbarActivity
import iherrera.cursokotlin.com.Section_02.Enums.PermissionStatusEnum
import kotlinx.android.synthetic.main.activity_dexter.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class DexterActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dexter)

        toolbarToLoad(toolbar as Toolbar)

        buttonCamera.setOnClickListener   { setPermissionHandler(Manifest.permission.CAMERA, textViewCamera) }
        buttonContacts.setOnClickListener { setPermissionHandler(Manifest.permission.READ_CONTACTS, textViewContacts) }
        buttonAudio.setOnClickListener    { setPermissionHandler(Manifest.permission.RECORD_AUDIO, textViewAudio) }

    }

    private fun setPermissionHandler(permission: String, textView: TextView) {
        Dexter.withContext(this)
            .withPermission(permission)
            .withListener(object: PermissionListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    setPermissionStatus(textView, PermissionStatusEnum.GRANTED)
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    if (p0!!.isPermanentlyDenied) {
                        setPermissionStatus(textView, PermissionStatusEnum.PERMANENTLY_DENIED)
                    } else {
                        setPermissionStatus(textView, PermissionStatusEnum.DENIED)
                    }
                }

                override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, p1: PermissionToken?) {
                    p1!!.continuePermissionRequest()
                }
            })
            .check()
    }

    private fun setPermissionStatus(textView: TextView, status: PermissionStatusEnum) {
        when (status) {
            PermissionStatusEnum.GRANTED -> {
                textView.text = "Granted!"
                textView.setTextColor(ContextCompat.getColor(this, R.color.colorPermissionStatusGranted))
            }
            PermissionStatusEnum.DENIED -> {
                textView.text = "Denied!"
                textView.setTextColor(ContextCompat.getColor(this, R.color.colorPermissionStatusDenied))
            }
            PermissionStatusEnum.PERMANENTLY_DENIED -> {
                textView.text = "Permanently Denied!"
                textView.setTextColor(ContextCompat.getColor(this, R.color.colorPermissionStatusPermanentlyDenied))
            }
        }
    }
}