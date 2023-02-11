package com.allaber.clean.di

import com.allaber.clean.domain.repository.UserRepository
import com.allaber.clean.domain.usecase.GetUserNameUseCase
import com.allaber.clean.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}