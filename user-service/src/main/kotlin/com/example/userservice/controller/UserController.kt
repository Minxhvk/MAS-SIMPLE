package com.example.userservice.controller

import com.example.userservice.compnent.Greeting
import com.example.userservice.controller.user.CreateUserRequest
import com.example.userservice.controller.user.CreateUserResponse
import com.example.userservice.dto.user.UserDto
import com.example.userservice.service.UserService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user-service/")
class UserController(
    @Autowired
    private val userService: UserService,
) {

    @GetMapping("/health_check")
    fun status(request: HttpServletRequest): String {
        return "It's Working in User Service on Port ${request.serverPort}"
    }

    @PostMapping("/users")
    fun createUser(@RequestBody createUserRequest: @Valid CreateUserRequest): ResponseEntity<CreateUserResponse> {

        val user = userService.createUser(createUserRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponse.of(user))
    }

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<UserDto>> {

        val userList = userService.getUserByAll()
        val userDtoList = userList.map { user -> UserDto.of(user) }

        return ResponseEntity.status(HttpStatus.OK).body(userDtoList)
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable("userId") userId: Long): ResponseEntity<UserDto> {

        val userEntity = userService.getUserById(userId)
        val userDto = UserDto.of(userEntity)

        return ResponseEntity.status(HttpStatus.OK).body(userDto)
    }
}