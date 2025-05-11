import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.travelplanner.R

class BookingActivity : AppCompatActivity() {

    private lateinit var fromEditText: EditText
    private lateinit var toEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var searchButton: Button

    companion object {
        val punkPink = 0xFF6392F0.toInt() // Equivalent to Color.fromARGB(255, 99, 146, 240)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        // Initialize views
        fromEditText = findViewById(R.id.fromEditText)
        toEditText = findViewById(R.id.toEditText)
        dateEditText = findViewById(R.id.dateEditText)
        searchButton = findViewById(R.id.searchButton)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Book Your Flight"
        toolbar.setBackgroundColor(punkPink)

        // Set up search button
        searchButton.setBackgroundColor(punkPink)
        searchButton.setOnClickListener {
            val from = fromEditText.text.toString()
            val to = toEditText.text.toString()
            val date = dateEditText.text.toString()

            if (from.isEmpty() || to.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Navigate to ListOfFlightsActivity
            val intent = Intent(this, ListOfFlightsActivity::class.java)
            startActivity(intent)
        }
    }
}