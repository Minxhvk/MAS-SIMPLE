package com.example.userservice.dto.user

import com.example.userservice.domain.user.UserEntity
import java.time.LocalDateTime

data class UserDto(
    val userId: Long?,
    val email: String,
    val name: String,
    val createdAt: LocalDateTime,
) {

    companion object {
        fun of(user: UserEntity): UserDto {
            return UserDto(
                userId = user.id,
                email = user.email,
                name = user.name,
                createdAt = user.createdAt,
            )
        }
    }
}