package com.example.savegatdata.domain.repository

import com.example.savegatdata.domain.models.SaveUserNameParams
import com.example.savegatdata.domain.models.UserName

interface UserRepository {
    fun saveName(params: SaveUserNameParams): Boolean
    fun getUserName(): UserName
}