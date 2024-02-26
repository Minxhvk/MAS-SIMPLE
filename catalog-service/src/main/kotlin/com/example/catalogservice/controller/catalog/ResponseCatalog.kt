package com.example.catalogservice.controller.catalog

import com.example.catalogservice.domain.catalog.CatalogEntity
import java.time.LocalDateTime

data class ResponseCatalog(
    val productId: String,
    val productName: String,
    val unitPrice: Int,
    val stock: Int,
    val createdAt: LocalDateTime
) {

    companion object {
        fun of(catalog: CatalogEntity): ResponseCatalog {
            return ResponseCatalog(
                productId = catalog.productId,
                productName = catalog.productName,
                stock = catalog.stock,
                unitPrice = catalog.unitPrice,
                createdAt = catalog.createdAt,
            )
        }
    }
}