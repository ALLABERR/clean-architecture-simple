package com.allaber.clean.presenation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.allaber.clean.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


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