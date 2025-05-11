package com.example.travelplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class ItineraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itinerary)

        val imgItinerary = findViewById<ImageView>(R.id.imgItinerary)
        imgItinerary.setImageResource(R.drawable.tokyo)
    }
}