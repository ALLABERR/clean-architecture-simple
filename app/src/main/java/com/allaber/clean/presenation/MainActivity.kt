package com.allaber.clean.presenation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.allaber.clean.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val sharedPrefUserStorage by lazy(LazyThreadSafetyMode.NONE) {
        com.allaber.clean.data.storage.sharedprefs.SharedPrefUserStorage(
            context = applicationContext
        )
    }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        com.allaber.clean.data.repository.UserRepositoryImpl(
            sharedPrefUserStorage
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.allaber.clean.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.allaber.clean.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener(){
            val text = binding.dataEditView.text.toString()
            val params = com.allaber.clean.domain.models.SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = "Save result $result"
        }

        binding.receiveButton.setOnClickListener(){
            val userName: com.allaber.clean.domain.models.UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}