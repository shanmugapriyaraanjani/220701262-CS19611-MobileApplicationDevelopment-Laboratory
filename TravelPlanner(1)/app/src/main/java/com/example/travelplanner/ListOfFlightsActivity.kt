import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.travelplanner.R

class ListOfFlightsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_flights)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Available Flights"
        //toolbar.setBackgroundColor(resources.getColor(R.color.primary_blue))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Sample flight data - in a real app, this would come from an API
        val flights = listOf(
            "New York (JFK) to London (LHR) - 10:00 AM - \$499",
            "New York (JFK) to London (LHR) - 2:30 PM - \$429",
            "New York (JFK) to London (LHR) - 6:45 PM - \$599",
            "New York (JFK) to London (LHR) - 9:15 PM - \$389"
        )

        // Set up ListView with flight data
        val listView = findViewById<ListView>(R.id.flightsListView)
        listView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            flights
        )

        // Handle flight selection
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Flight selected: ${flights[position]}",
                Toast.LENGTH_SHORT
            ).show()
            // Here you would typically proceed to booking confirmation
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}