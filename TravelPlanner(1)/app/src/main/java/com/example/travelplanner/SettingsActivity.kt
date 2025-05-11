package com.example.travelplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Switch
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchDarkMode = findViewById<Switch>(R.id.switchDarkMode)
        val imgSettings = findViewById<ImageView>(R.id.imgSettings)

        imgSettings.setImageResource(R.drawable.sydney)

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Enable dark mode
            } else {
                // Disable dark mode
            }
        }
    }
}