package iherrera.cursokotlin.com.Section_03.Listeners

import iherrera.cursokotlin.com.Section_03.Models.Flight

interface RecyclerFlightListener {
    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}