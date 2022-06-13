package com.sintof.studyarch.domain.repository

import com.sintof.studyarch.domain.models.SaveUserNameParam
import com.sintof.studyarch.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}