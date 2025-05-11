import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.travelplanner.R

class ViewPlanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_plan)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Your Travel Plan"
        //toolbar.setBackgroundColor(resources.getColor(R.color.primary_blue))

        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get data from intent
        val destination = intent.getStringExtra("destination") ?: ""
        val startDate = intent.getStringExtra("startDate") ?: ""
        val endDate = intent.getStringExtra("endDate") ?: ""
        val activities = intent.getStringExtra("activities") ?: ""

        // Display the data
        findViewById<TextView>(R.id.destinationText).text = "Destination: $destination"
        findViewById<TextView>(R.id.datesText).text = "From: $startDate\nTo: $endDate"
        findViewById<TextView>(R.id.activitiesText).text = "Activities:\n$activities"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}