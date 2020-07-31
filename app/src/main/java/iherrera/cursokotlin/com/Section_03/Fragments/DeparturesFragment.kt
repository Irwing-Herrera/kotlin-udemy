package iherrera.cursokotlin.com.Section_03.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.toast
import iherrera.cursokotlin.com.Section_03.Adapters.FlightAdapter
import iherrera.cursokotlin.com.Section_03.Listeners.RecyclerFlightListener
import iherrera.cursokotlin.com.Section_03.Models.Flight
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    // Craga peresosa que se manda a llamar cuando se le asigna un valor a la variable
    private val list: ArrayList<Flight> by lazy { _getFlights() }

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        activity?.title = "Departures"

        recycler = rootView.recyclerView as RecyclerView
        _setRecyclerView()

        return rootView
    }

    private fun _setRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (FlightAdapter(list, object : RecyclerFlightListener {
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let´s go to ${flight.city}!")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been removed!")
            }

        }))
        recycler.adapter = adapter
    }

    private fun _getFlights(): ArrayList<Flight> {
        return object : ArrayList<Flight>() {
            init {
                add(Flight(1, "City 1", R.drawable.city))
                add(Flight(2, "City 2", R.drawable.city))
                add(Flight(3, "City 3", R.drawable.city))
                add(Flight(4, "City 4", R.drawable.city))
                add(Flight(5, "City 5", R.drawable.city))
                add(Flight(6, "City 6", R.drawable.city))
            }
        }
    }
}