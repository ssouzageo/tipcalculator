package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.example.tipcalculator.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople",0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalWithTips = intent.getFloatExtra("totalTips", 0.0f)

        binding.tvPercentage.text = percentage.toString()
        binding.tvTotaltable.text = totalTable.toString()
        binding.tvNumofpeople.text = numPeople.toString()
        binding.tvTotalamount.text = totalWithTips.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }
    }
}