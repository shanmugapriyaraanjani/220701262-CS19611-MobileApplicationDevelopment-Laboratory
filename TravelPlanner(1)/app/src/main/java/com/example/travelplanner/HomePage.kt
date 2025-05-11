package com.example.travelplanner

import BookingActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class HomePage : AppCompatActivity() {

    private lateinit var imageCarousel: ViewPager2
    private lateinit var suggestionList: RecyclerView
    private lateinit var profileIcon: ImageView
    private lateinit var settingsIcon: ImageView
    private lateinit var navIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Toolbar icons
        profileIcon = findViewById(R.id.profileIcon)
        settingsIcon = findViewById(R.id.settingsIcon)
        navIcon = findViewById(R.id.navIcon)

        profileIcon.setOnClickListener {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, ProfileActivity::class.java))
        }

        settingsIcon.setOnClickListener {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, SettingsActivity::class.java))
        }

        navIcon.setOnClickListener {
            Toast.makeText(this, "Navigation clicked", Toast.LENGTH_SHORT).show()
            // Handle navigation drawer logic
        }

        // Setup carousel
        imageCarousel = findViewById(R.id.imageCarousel)
        val carouselImages = listOf(
            R.drawable.sydney, R.drawable.tokyo, R.drawable.sydney
        )
        val carouselAdapter = CarouselAdapter(carouselImages)
        imageCarousel.adapter = carouselAdapter

        // Setup suggested destinations list
        suggestionList = findViewById(R.id.rvSuggestions)
        val destinationAdapter = DestinationAdapter(
            listOf("Bali", "New York", "Maldives", "Iceland")
        )
        suggestionList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        suggestionList.adapter = destinationAdapter

        // Setup feature buttons
        findViewById<LinearLayout>(R.id.btnPlanTrip).setOnClickListener {
            //Toast.makeText(this, "Plan Your Trip clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PlanTripActivity::class.java)
            startActivity(intent)
            // startActivity(Intent(this, PlanTripActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnBookFlight).setOnClickListener {
            //Toast.makeText(this, "Book Flight clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
            // startActivity(Intent(this, BookFlightActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnViewDestinations).setOnClickListener {
            Toast.makeText(this, "View Destinations clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, DestinationsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnBudgetTracker).setOnClickListener {
            Toast.makeText(this, "Budget Tracker clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, BudgetActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnRecommendations).setOnClickListener {
            Toast.makeText(this, "Recommendations clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, RecommendationsActivity::class.java))
        }
    }
}