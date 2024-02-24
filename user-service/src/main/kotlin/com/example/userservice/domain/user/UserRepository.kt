package com.example.userservice.domain.user

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {

}