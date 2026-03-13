package com.example.linearlayoutapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.linearlayoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonConverterDolares.setOnClickListener {
            var valorEuros = binding.editValorEuros.text.toString().toDouble()

            var valorDolares = String.format("%.2f", valorEuros * 1.2).toDouble()

            Toast.makeText(applicationContext, "Dolares: $valorDolares$", Toast.LENGTH_LONG).show()
        }

        binding.buttonConverterReais.setOnClickListener {
            var valorEuros = binding.editValorEuros.text.toString().toDouble()

            var valorReais = String.format("%.2f", valorEuros * 6).toDouble()

            Toast.makeText(applicationContext, "Reais: $valorReais R$", Toast.LENGTH_LONG).show()
        }

        binding.buttonConverterLibras.setOnClickListener {
            var valorEuros = binding.editValorEuros.text.toString().toDouble()

            var valorLibras = String.format("%.2f", valorEuros * 0.85).toDouble()

            Toast.makeText(applicationContext, "Libras: $valorLibras £", Toast.LENGTH_LONG).show()
        }
    }
}