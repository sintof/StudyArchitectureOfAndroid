package com.sintof.studyarch.data.repository

import android.content.Context
import com.sintof.studyarch.domain.models.SaveUserNameParam
import com.sintof.studyarch.domain.models.UserName
import com.sintof.studyarch.domain.repository.UserRepository


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class UserRepositoryImpl(private val context: Context) : UserRepository {


    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()

        return true
    }
    override fun getName(): UserName{

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: ""
        val lastName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: "Default lastname"

        return UserName(firstName = firstName, lastName = lastName)
    }

}