package com.alphabet.rive_example_137

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.rive.runtime.kotlin.core.Rive
import com.alphabet.rive_example_137.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val stateMachineName = "State Machine 1"
    val inputBooleanName = "check"

    var isFav = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Rive.init(this)

        binding.riveAnimView.setOnClickListener {

            if(isFav){
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanName, false)
                isFav = false
            } else {
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanName, true)
                isFav = true
            }

        }


    }
}

