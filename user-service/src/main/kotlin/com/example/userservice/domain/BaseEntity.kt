package com.example.userservice.domain

import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false, unique = true)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column
    val updateDate: LocalDateTime = LocalDateTime.now()

    override fun equals(other: Any?): Boolean {

        other ?: return false

        if (other !is HibernateProxy && this::class != other::class) {
            return false
        }

        return id == getIdentifier(other)
    }

    private fun getIdentifier(obj: Any): Any? {
        return if (obj is HibernateProxy) {
            obj.hibernateLazyInitializer.identifier
        }  else {
            (obj as BaseEntity).id
        }
    }

    override fun hashCode() = Objects.hashCode(id)
}