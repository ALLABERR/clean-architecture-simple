package com.allaber.clean.presenation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.allaber.clean.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity created")

        vm.resultLive.observe(this) { text ->
            binding.dataTextView.text = text
        }

        binding.sendButton.setOnClickListener(){
            val text = binding.dataEditView.text.toString()
            vm.save(text)
        }

        binding.receiveButton.setOnClickListener(){
            vm.load()
        }
    }
}