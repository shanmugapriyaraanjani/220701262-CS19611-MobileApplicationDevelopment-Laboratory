package com.example.travelplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val animationView = findViewById<LottieAnimationView>(R.id.lottieAnimation)

        animationView.setAnimation(R.raw.splash_animation)
        animationView.playAnimation()
        btnLogin.setOnClickListener {
            if (edtUsername.text.isNotEmpty() && edtPassword.text.isNotEmpty()) {
                startActivity(Intent(this, HomePage::class.java))
            } else {
                Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}