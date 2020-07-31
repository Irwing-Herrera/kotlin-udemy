package iherrera.cursokotlin.com.Section_03.Activities

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.ToolbarActivity
import iherrera.cursokotlin.com.Section_01.Others.toast
import iherrera.cursokotlin.com.Section_03.Fragments.ArrivalsFragment
import iherrera.cursokotlin.com.Section_03.Fragments.DeparturesFragment
import iherrera.cursokotlin.com.Section_03.Fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main_section03.*

class MainSection03Activity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_section03)

        toolbarToLoad(toolbar as Toolbar)

        _setNavDrawer()
        _setUserHeaderInformation()

        if (savedInstanceState == null) {
            _fragmentTransaction(HomeFragment())
            navView.menu.getItem(0).isChecked = true
        }

    }

    private fun _setNavDrawer() {
        val TOGGLE = ActionBarDrawerToggle(this, drawerlayout, _toolbar, R.string.open_drawer, R.string.close_drawer)
        TOGGLE.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(TOGGLE)
        TOGGLE.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun _fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun _loadFragmentById(id: Int) {
        when (id) {
            R.id.nav_home -> _fragmentTransaction(HomeFragment())
            R.id.nav_departures -> _fragmentTransaction(DeparturesFragment())
            R.id.nav_arrivals -> _fragmentTransaction(ArrivalsFragment())
        }
    }

    private fun _showMessageNavItemSelectedById(id: Int) {
        when (id) {
            R.id.nav_profile -> toast("Profile")
            R.id.nav_settings -> toast("Settings")
        }
    }

    private fun _setUserHeaderInformation() {
        var name = navView.getHeaderView(0).findViewById<TextView>(R.id.headerTextViewName)
        var email = navView.getHeaderView(0).findViewById<TextView>(R.id.headerTextViewEmail)

        name?.let { name.text = "Irwing Herrera" }
        email?.let { email.text = "iherrera@gmail.com" }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        _showMessageNavItemSelectedById(item.itemId)
        _loadFragmentById(item.itemId)
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START))
            drawerlayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}