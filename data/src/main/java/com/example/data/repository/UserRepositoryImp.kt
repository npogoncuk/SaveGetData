package com.example.data.repository

import android.util.Log
import com.example.data.storage.models.User
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserNameParams
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.UserNameParamsToUserNameUseCase

class UserRepositoryImp(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(params: SaveUserNameParams): Boolean {
        val userName = UserNameParamsToUserNameUseCase().invoke(params)
        Log.d("UserRepImpl  save", userName.toString())
        userStorage.save(User(userName.firstName, userName.lastName))
        return true
    }

    override fun getUserName(): UserName {
        val user = userStorage.get()
        Log.d("UserRepImpl  get", user.toString())
        return UserName(user.firstName, user.lastName)
    }

}