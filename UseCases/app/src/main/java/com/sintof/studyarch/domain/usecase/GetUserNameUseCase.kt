package com.sintof.studyarch.domain.usecase

import com.sintof.studyarch.domain.models.UserName
import com.sintof.studyarch.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}