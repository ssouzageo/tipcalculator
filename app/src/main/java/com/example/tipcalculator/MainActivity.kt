package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }

            binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    percentage = 15
                }

                binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        percentage = 20
                    }
                }
            }
        }
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerNumberOfPeople.adapter = adapter

        var NumOfPeopleSelected = 0
        binding.spinnerNumberOfPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                NumOfPeopleSelected = position
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        binding.btnClean.setOnClickListener {
            clean()
        }
        binding.btnDone.setOnClickListener {

            val totalTableTemp = binding.tieTotal.text

            if (totalTableTemp?.isEmpty() == true) {
                Snackbar.make(binding.tilTotal, "Preencha todos os campos.", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val totalTable: Float = totalTableTemp.toString().toFloat()
                val numPeople: Int = NumOfPeopleSelected

                val totalTemp = totalTable / numPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SummaryActivity :: class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", numPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalTips", totalWithTips)
                }
                clean()
                startActivity(intent)
            }
        }
    }
    private fun clean() {
            binding.tieTotal.setText("")
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
            binding.rbOptionThree.isChecked = false
    }
}