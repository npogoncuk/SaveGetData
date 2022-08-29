package com.example.domain.repository

import com.example.domain.models.SaveUserNameParams
import com.example.domain.models.UserName

interface UserRepository {
    fun saveName(params: SaveUserNameParams): Boolean
    fun getUserName(): UserName
}