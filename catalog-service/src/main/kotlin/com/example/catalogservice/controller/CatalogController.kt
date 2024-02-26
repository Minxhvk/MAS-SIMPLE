package com.example.catalogservice.controller

import com.example.catalogservice.controller.catalog.ResponseCatalog
import com.example.catalogservice.service.CatalogService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog-service")
class CatalogController(
    @Autowired
    val catalogService: CatalogService,
    val env: Environment,
) {

    @GetMapping("/health_check")
    fun status(request: HttpServletRequest): String {
        return "It's Working in Catalog Service on Port ${request.serverPort}"
    }

    @GetMapping("/catalogs")
    fun getAllCatalogs(): ResponseEntity<List<ResponseCatalog>> {

        val catalogList = catalogService.getAllCatalogs()
        val result = catalogList.map { catalog -> ResponseCatalog.of(catalog) }

        return ResponseEntity.status(HttpStatus.OK).body(result)
    }


}