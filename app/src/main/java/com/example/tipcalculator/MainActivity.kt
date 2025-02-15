package com.example.tipcalculator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    /*
    1. Título;
    2. Subtítulo;
    3. Valor total;
    4. Quantidade de pessoas;
    5. Porcentagem (10%, 15%, 20%);
    6. Botão limpar;
    7. Botão calcular;
    8. Ids;
    9. Recuperar as views do layout; e
    10. Usar o ViewBiding.
     */

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

        binding.btnClean.setOnClickListener {

            println("Geo clean " + binding.tieTotal.text)
            println("Geo clean " + binding.tieNumpeople.text)

        }

        binding.btnDone.setOnClickListener {

            val totalTable: Float = binding.tieTotal.text.toString().toFloat()
            val numPeople: Int = binding.tieNumpeople.text.toString().toInt()

            val totalTemp = totalTable / numPeople
            val tips = totalTemp * percentage / 100
            val totalWithtTips = totalTemp + tips

            println("Geo "+ totalWithtTips)
        }
    }

}