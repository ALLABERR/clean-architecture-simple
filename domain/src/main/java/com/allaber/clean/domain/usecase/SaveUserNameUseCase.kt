package com.allaber.clean.domain.usecase

import com.allaber.clean.domain.models.SaveUserNameParam
import com.allaber.clean.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {

        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name) {
            return true
        }

        return userRepository.saveName(param)
    }
}