package com.example.travelplanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class TripPlanningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_planning)

        val edtDestination = findViewById<EditText>(R.id.edtDestination)
        val btnSaveTrip = findViewById<Button>(R.id.btnSaveTrip)
        val imgTrip = findViewById<ImageView>(R.id.imgTrip)

        imgTrip.setImageResource(R.drawable.tokyo)

        btnSaveTrip.setOnClickListener {
            // Save trip logic
        }
    }
}