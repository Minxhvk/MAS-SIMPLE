package com.example.userservice.controller.user

import com.example.userservice.domain.user.UserEntity

data class CreateUserResponse(
    val id: Long?,
    val email: String,
    val name: String,
) {

    companion object {
        fun of(user: UserEntity): CreateUserResponse {
            return CreateUserResponse(
                id = user.id,
                email = user.email,
                name = user.name,
            )
        }
    }
}
