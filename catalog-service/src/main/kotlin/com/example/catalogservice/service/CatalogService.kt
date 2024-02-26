package com.example.catalogservice.service

import com.example.catalogservice.domain.catalog.CatalogEntity
import com.example.catalogservice.domain.catalog.CatalogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CatalogService(
    @Autowired
    val catalogRepository: CatalogRepository
) {

    fun getAllCatalogs(): Iterable<CatalogEntity> {
        return catalogRepository.findAll()
    }
}