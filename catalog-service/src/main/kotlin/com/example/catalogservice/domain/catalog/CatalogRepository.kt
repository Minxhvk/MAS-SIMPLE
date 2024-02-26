package com.example.catalogservice.domain.catalog

import org.springframework.data.repository.CrudRepository

interface CatalogRepository: CrudRepository<CatalogEntity, Long> {

    fun findByProductId(productId: String)
}