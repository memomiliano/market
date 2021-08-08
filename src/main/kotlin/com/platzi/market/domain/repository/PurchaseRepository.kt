package com.platzi.market.domain.repository

import com.platzi.market.domain.Purchase

interface PurchaseRepository {
    fun getAll(): List<Purchase>
    fun getByClient(clientId: String): List<Purchase>?
    fun save(purchase: Purchase): Purchase
}