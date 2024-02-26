package com.example.userservice.domain

import com.example.catalogservice.domain.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity: BaseTimeEntity() {

    @CreatedBy
    @Column(updatable = false)
    val createdBy: String? = null

    @LastModifiedBy
    var lastModifiedBy: String? = null
}