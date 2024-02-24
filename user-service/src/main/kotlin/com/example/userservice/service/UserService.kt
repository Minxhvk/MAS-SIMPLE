package com.example.userservice.service

import com.example.userservice.controller.user.CreateUserRequest
import com.example.userservice.domain.user.UserEntity
import com.example.userservice.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    @Autowired
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
) {

    fun createUser(createUserRequest: CreateUserRequest): UserEntity {
        val userEntity = UserEntity(
            name = createUserRequest.name,
            email = createUserRequest.email,
            encryptedPwd = passwordEncoder.encode(createUserRequest.password),
        )

        userRepository.save(userEntity)

        return userEntity
    }
}