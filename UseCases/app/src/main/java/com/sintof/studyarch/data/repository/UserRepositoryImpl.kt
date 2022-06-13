package com.sintof.studyarch.data.repository

import android.content.Context
import com.sintof.studyarch.data.storage.UserStorage
import com.sintof.studyarch.data.storage.models.User
import com.sintof.studyarch.domain.models.SaveUserNameParam
import com.sintof.studyarch.domain.models.UserName
import com.sintof.studyarch.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val result = userStorage.save(mapToStorage(saveParam))
        return result
    }
    override fun getName(): UserName{
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

}