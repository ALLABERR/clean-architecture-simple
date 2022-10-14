package com.allaber.clean.domain.repository

import com.allaber.clean.domain.models.SaveUserNameParam
import com.allaber.clean.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}