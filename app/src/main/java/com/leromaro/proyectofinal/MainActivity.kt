package com.leromaro.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.leromaro.proyectofinal.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.result.observe(this) {
            binding.TVResultado.text ="${it.result}"
        }

        binding.BTNComparar.setOnClickListener {
            mainViewModel.comparar(binding.ETPrimero.text.toString(), binding.ETSegundo.text.toString())
        }
    }
}


