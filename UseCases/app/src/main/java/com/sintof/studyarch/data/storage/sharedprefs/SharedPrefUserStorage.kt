package com.sintof.studyarch.data.storage.sharedprefs

import android.content.Context
import com.sintof.studyarch.data.storage.UserStorage
import com.sintof.studyarch.data.storage.models.User
import com.sintof.studyarch.domain.models.SaveUserNameParam
import com.sintof.studyarch.domain.models.UserName

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }
    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: "none"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "")?:  "none"
        return User(firstName = firstName, lastName = lastName)
    }
}