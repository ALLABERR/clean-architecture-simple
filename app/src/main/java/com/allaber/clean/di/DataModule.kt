package com.allaber.clean.di

import com.allaber.clean.data.repository.UserRepositoryImpl
import com.allaber.clean.data.storage.UserStorage
import com.allaber.clean.data.storage.sharedprefs.SharedPrefUserStorage
import com.allaber.clean.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}