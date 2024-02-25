package com.example.userservice.dto.order

import java.util.Date

data class OrderDto(
    val orderId: Long,
    val productId: Long,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: Date,
) {
}