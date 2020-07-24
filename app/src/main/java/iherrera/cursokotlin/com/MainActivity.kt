package iherrera.cursokotlin.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iherrera.cursokotlin.com.Others.Variables

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Variables().showCases()
    }
}