package com.allaber.clean.di

import com.allaber.clean.presenation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            saveUserNameUseCase = get(),
            getUserNameUseCase = get()
        )
    }
}