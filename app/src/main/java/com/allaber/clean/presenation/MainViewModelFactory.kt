package com.allaber.clean.presenation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.allaber.clean.data.repository.UserRepositoryImpl
import com.allaber.clean.data.storage.sharedprefs.SharedPrefUserStorage
import com.allaber.clean.domain.usecase.GetUserNameUseCase
import com.allaber.clean.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val sharedPrefUserStorage by lazy(LazyThreadSafetyMode.NONE) {
        SharedPrefUserStorage(context = context)
    }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            sharedPrefUserStorage
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }

}