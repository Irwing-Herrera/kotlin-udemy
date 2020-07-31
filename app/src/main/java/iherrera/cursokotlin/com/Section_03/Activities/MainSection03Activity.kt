package iherrera.cursokotlin.com.Section_03.Activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main_section03.*

class MainSection03Activity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_section03)

        toolbarToLoad(toolbar as Toolbar)
        setNavDrawer()
    }

    private fun setNavDrawer() {
        val TOGGLE = ActionBarDrawerToggle(this, drawerlayout, _toolbar, R.string.open_drawer, R.string.close_drawer)
        TOGGLE.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(TOGGLE)
        TOGGLE.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}