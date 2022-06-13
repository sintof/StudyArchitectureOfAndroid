package com.sintof.studyarch.domain.usecase

import com.sintof.studyarch.domain.models.SaveUserNameParam
import com.sintof.studyarch.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name) return true

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}