package com.example.domain.usecase

import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): UserName {
        return userRepository.getUserName()
    }
}