package com.example.travelplanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class BudgetTrackerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_tracker)

        val edtBudget = findViewById<EditText>(R.id.edtBudget)
        val btnSaveBudget = findViewById<Button>(R.id.btnSaveBudget)
        val imgBudget = findViewById<ImageView>(R.id.imgBudget)

        imgBudget.setImageResource(R.drawable.tokyo)

        btnSaveBudget.setOnClickListener {
            // Save budget logic
        }
    }
}