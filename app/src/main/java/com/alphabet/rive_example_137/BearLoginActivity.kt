package com.alphabet.rive_example_137

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import app.rive.runtime.kotlin.core.Rive
import com.alphabet.rive_example_137.databinding.ActivityBearLoginBinding

class BearLoginActivity : AppCompatActivity() {

    val stateMachineName = "Login Machine"
    val inputBooleanChecking = "isChecking"
    val inputBooleanHandsUp = "isHandsUp"
    val inputTriggerSuccess = "trigSuccess"
    val inputTriggerFailure = "trigFail"
    val inputNumberNumLook = "numLook"
    var isChecking = false
    var isHandsUp = false

    lateinit var binding: ActivityBearLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBearLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Rive.init(this)

        binding.edtName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanChecking, true)
                binding.riveAnimView.controller.setNumberState(stateMachineName, inputNumberNumLook, s!!.length.toFloat())

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        binding.btnChecking.setOnClickListener {
            if(isChecking){
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanChecking, false)
                isChecking = false
            } else {
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanChecking, true)
                isChecking = true
            }
        }

        binding.btnHandsUp.setOnClickListener {
            if(isHandsUp){
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanHandsUp, false)
                isHandsUp = false
            } else {
                binding.riveAnimView.controller.setBooleanState(stateMachineName, inputBooleanHandsUp, true)
                isHandsUp = true
            }
        }

        binding.btnTrigSuccess.setOnClickListener {
            binding.riveAnimView.controller.fireState(stateMachineName, inputTriggerSuccess)
        }

        binding.btnTrigFail.setOnClickListener {
            binding.riveAnimView.controller.fireState(stateMachineName, inputTriggerFailure)
        }
    }
}