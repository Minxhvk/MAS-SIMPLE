package com.example.userservice.dto.user

import java.util.*

data class UserDto(
    val id: Long,
    val email: String,
    val name: String,
    val createdAt: Date,
)