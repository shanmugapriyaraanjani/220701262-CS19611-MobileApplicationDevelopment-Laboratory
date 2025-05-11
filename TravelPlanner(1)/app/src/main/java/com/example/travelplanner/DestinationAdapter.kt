package com.example.travelplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinationAdapter(private val destinations: List<String>) :
    RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtDestination: TextView = itemView.findViewById(R.id.txtDestination)
        val layoutDestination: LinearLayout = itemView.findViewById(R.id.layoutDestination)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destinationName = destinations[position]
        holder.txtDestination.text = destinationName

        // Set background dynamically
        val context = holder.itemView.context
        val imageName = destinationName.lowercase().replace(" ", "") // e.g., New York -> newyork
        val backgroundResId = context.resources.getIdentifier(imageName, "drawable", context.packageName)

        if (backgroundResId != 0) {
            holder.layoutDestination.setBackgroundResource(backgroundResId)
        } else {
           holder.layoutDestination.setBackgroundResource(R.drawable.tokyo) // fallback background
        }
    }

    override fun getItemCount(): Int = destinations.size
}
