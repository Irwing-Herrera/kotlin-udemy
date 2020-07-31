package iherrera.cursokotlin.com.Section_03.Adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Others.inflate
import iherrera.cursokotlin.com.Section_01.Others.loadByResource
import iherrera.cursokotlin.com.Section_03.Listeners.RecyclerFlightListener
import iherrera.cursokotlin.com.Section_03.Models.Flight
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter(
    private val flights: List<Flight>,
    private val listener: RecyclerFlightListener
) : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.recycler_flight))

    override fun getItemCount(): Int = flights.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(flights[position], listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView) {
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)

            // Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }

}