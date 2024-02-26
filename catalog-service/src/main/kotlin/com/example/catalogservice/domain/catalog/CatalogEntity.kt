package com.example.catalogservice.domain.catalog

import com.example.catalogservice.domain.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "catalog")
class CatalogEntity(
    productId: String,
    productName: String,
    stock: Int,
    unitPrice: Int,
): BaseTimeEntity() {

    @Column(nullable = false, length = 120, unique = true)
    var productId: String = productId
        protected set

    @Column(nullable = false, length = 50)
    var productName: String = productName
        protected set

    @Column(nullable = false)
    var stock: Int = stock
        protected set

    @Column(nullable = false)
    var unitPrice: Int = unitPrice
        protected set
}