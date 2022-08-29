package com.example.savegatdata.domain.usecase

import com.example.savegatdata.domain.models.SaveUserNameParams
import com.example.savegatdata.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(params: SaveUserNameParams): Boolean {
        return userRepository.saveName(params)
    }
}