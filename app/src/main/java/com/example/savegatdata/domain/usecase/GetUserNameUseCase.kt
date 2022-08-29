package com.example.savegatdata.domain.usecase

import com.example.savegatdata.domain.models.UserName
import com.example.savegatdata.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): UserName {
        return userRepository.getUserName()
    }
}