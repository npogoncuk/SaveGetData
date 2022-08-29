package com.example.domain.usecase

import com.example.domain.models.SaveUserNameParams
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(params: SaveUserNameParams): Boolean {
        return userRepository.saveName(params)
    }
}