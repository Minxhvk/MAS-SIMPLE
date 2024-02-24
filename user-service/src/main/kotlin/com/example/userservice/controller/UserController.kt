package com.example.userservice.controller

import com.example.userservice.compnent.Greeting
import com.example.userservice.controller.user.CreateUserRequest
import com.example.userservice.controller.user.CreateUserResponse
import com.example.userservice.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UserController(
    @Autowired
    private val greeting: Greeting,
    private val userService: UserService,
) {

    @GetMapping("/health_check")
    fun status(): String {
        return "It's Working in User Service"
    }

    @GetMapping("/welcome")
    fun welcome(): String {
        return greeting.message
    }

    @PostMapping("/users")
    fun createUser(@RequestBody createUserRequest: @Valid CreateUserRequest): ResponseEntity<CreateUserResponse> {
        val user = userService.createUser(createUserRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponse.of(user))
    }
}