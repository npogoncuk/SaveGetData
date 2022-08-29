package com.example.savegatdata.data.storage

import com.example.savegatdata.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}