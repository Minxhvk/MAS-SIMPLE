package com.example.userservice.controller.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class CreateUserRequest(

    @Size(min = 2, message = "Email not be less than 2 characters")
    @Email
    val email: String,

    @Size(min = 2, message = "Name not be less than 2 characters")
    val name: String,

    @Size(min = 8, message = "Password not be less than 8 characters")
    val password: String
)