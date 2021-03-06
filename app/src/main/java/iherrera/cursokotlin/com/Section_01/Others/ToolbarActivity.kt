package iherrera.cursokotlin.com.Section_01.Others

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import iherrera.cursokotlin.com.Section_01.Models.iToolbar

open class ToolbarActivity : AppCompatActivity(), iToolbar {

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}