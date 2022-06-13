package com.sintof.studyarch.data.storage

import com.sintof.studyarch.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}