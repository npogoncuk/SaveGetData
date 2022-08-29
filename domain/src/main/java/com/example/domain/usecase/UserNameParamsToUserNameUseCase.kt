package com.example.domain.usecase

import com.example.domain.models.SaveUserNameParams
import com.example.domain.models.UserName

class UserNameParamsToUserNameUseCase {
    operator fun invoke(params: SaveUserNameParams): UserName {
        val indexOfSpace = params.name.indexOf(' ')
        var firstName: String
        val lastName: String
        if (indexOfSpace == -1) {
            firstName = params.name
            lastName = ""
        } else {
            firstName = params.name.substring(0, indexOfSpace)
            lastName = params.name.substring(indexOfSpace + 1)
        }

        if (firstName.isEmpty() && lastName.isEmpty()) firstName = "No data"
        return UserName(firstName, lastName)
    }
}