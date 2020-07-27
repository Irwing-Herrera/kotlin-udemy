package iherrera.cursokotlin.com.Section_01.Others

import android.os.Bundle
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Utils.LifeCycleEventsActivity

class LifeCycleEventsActivity : LifeCycleEventsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_events)
    }
}