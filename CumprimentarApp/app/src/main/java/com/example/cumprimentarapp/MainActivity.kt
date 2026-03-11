package com.example.cumprimentarapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cumprimentarapp.databinding.ActivityMainBinding

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

        binding.buttonDizerOla.setOnClickListener {

            var nomeUser = binding.editNome.text.toString()
            var apelidoUser = binding.editApelido.text.toString()

            if (nomeUser.isEmpty()) {
                Toast.makeText(applicationContext,"Por favor, insira o seu nome",Toast.LENGTH_SHORT).show()
            } else if (apelidoUser.isEmpty()) {
                Toast.makeText(applicationContext,"Por favor, insira o seu apelido",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"Boa tarde, $nomeUser $apelidoUser",Toast.LENGTH_SHORT).show()
            }


        }
    }
}

