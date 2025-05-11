package com.example.travelplanner
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class SignupActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var signupButton: Button
    private lateinit var txtLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize views
        usernameEditText = findViewById(R.id.edtUsername)
        passwordEditText = findViewById(R.id.edtPassword)
        confirmPasswordEditText = findViewById(R.id.edtConfirmPassword)
        signupButton = findViewById(R.id.btnSignup)
        txtLogin = findViewById<TextView>(R.id.txtLogin)
        // On button click
        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            } else {
                // Success case: You can navigate to another activity or save data
                Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            // Example: startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        txtLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: Close SignupActivity
        }
    }
}