package com.allaber.clean.data.repository

import com.allaber.clean.data.storage.models.User
import com.allaber.clean.data.storage.UserStorage
import com.allaber.clean.domain.models.SaveUserNameParam
import com.allaber.clean.domain.models.UserName
import com.allaber.clean.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToDomain(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToStorage(user)
    }

    private fun mapToDomain(saveParam: SaveUserNameParam) : User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToStorage(user: User) : UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}