package com.example.travelplanner
import ViewPlanActivity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class PlanTripActivity : AppCompatActivity() {

    private lateinit var destinationEditText: EditText
    private lateinit var startDateEditText: EditText
    private lateinit var endDateEditText: EditText
    private lateinit var activitiesEditText: EditText
    private lateinit var saveButton: Button

    private val calendar = Calendar.getInstance()
    private var startDate: Date? = null
    private var endDate: Date? = null
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_trip)

        // Initialize views
        destinationEditText = findViewById(R.id.destinationEditText)
        startDateEditText = findViewById(R.id.startDateEditText)
        endDateEditText = findViewById(R.id.endDateEditText)
        activitiesEditText = findViewById(R.id.activitiesEditText)
        saveButton = findViewById(R.id.saveButton)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Plan Your Trip"
        //toolbar.setBackgroundColor(resources.getColor(R.color.primary_blue))

        // Set up date pickers
        startDateEditText.setOnClickListener { showDatePicker(true) }
        endDateEditText.setOnClickListener { showDatePicker(false) }

        // Make date fields non-editable
        startDateEditText.keyListener = null
        endDateEditText.keyListener = null

        // Set up save button
        saveButton.setOnClickListener {
            val destination = destinationEditText.text.toString()
            val activities = activitiesEditText.text.toString()

            if (destination.isEmpty() || startDate == null || endDate == null) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Start ViewPlanActivity with the trip details
            val intent = Intent(this, ViewPlanActivity::class.java).apply {
                putExtra("destination", destination)
                putExtra("startDate", dateFormat.format(startDate))
                putExtra("endDate", dateFormat.format(endDate))
                putExtra("activities", activities)
            }
            startActivity(intent)
        }
    }

    private fun setSupportActionBar(toolbar: Toolbar?) {
        TODO("Not yet implemented")
    }

    private fun showDatePicker(isStartDate: Boolean) {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, day ->
                calendar.set(year, month, day)
                val selectedDate = calendar.time

                if (isStartDate) {
                    startDate = selectedDate
                    startDateEditText.setText(dateFormat.format(selectedDate))
                } else {
                    endDate = selectedDate
                    endDateEditText.setText(dateFormat.format(selectedDate))
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }
}