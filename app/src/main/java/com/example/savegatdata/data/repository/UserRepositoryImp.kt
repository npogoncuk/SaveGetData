package com.example.savegatdata.data.repository

import com.example.savegatdata.data.storage.models.User
import com.example.savegatdata.data.storage.UserStorage
import com.example.savegatdata.domain.models.SaveUserNameParams
import com.example.savegatdata.domain.models.UserName
import com.example.savegatdata.domain.repository.UserRepository
import com.example.savegatdata.domain.usecase.UserNameParamsToUserNameUseCase

class UserRepositoryImp(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(params: SaveUserNameParams): Boolean {
        val userName = UserNameParamsToUserNameUseCase().invoke(params)
        userStorage.save(User(userName.firstName, userName.lastName))
        return true
    }

    override fun getUserName(): UserName {
        val user = userStorage.get()
        return UserName(user.firstName, user.lastName)
    }

}