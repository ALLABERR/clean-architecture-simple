package com.allaber.clean.domain.usecase

import com.allaber.clean.domain.models.UserName
import com.allaber.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}