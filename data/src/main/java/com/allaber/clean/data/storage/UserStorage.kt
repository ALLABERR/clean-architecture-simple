package com.allaber.clean.data.storage

import com.allaber.clean.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean

    fun get() : User
}