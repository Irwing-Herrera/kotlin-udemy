package iherrera.cursokotlin.com.Section_03.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iherrera.cursokotlin.com.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Home"

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}