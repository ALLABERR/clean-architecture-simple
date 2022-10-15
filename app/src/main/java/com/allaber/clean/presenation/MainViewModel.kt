package com.allaber.clean.presenation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allaber.clean.domain.models.SaveUserNameParam
import com.allaber.clean.domain.models.UserName
import com.allaber.clean.domain.usecase.GetUserNameUseCase
import com.allaber.clean.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        resultLiveMutable.value = "Save result = " + saveUserNameUseCase.execute(param = params)
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}