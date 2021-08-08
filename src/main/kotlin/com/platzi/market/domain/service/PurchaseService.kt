package com.platzi.market.domain.service

import com.platzi.market.domain.Product
import com.platzi.market.domain.Purchase
import com.platzi.market.persistence.CompraRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PurchaseService {

    @Autowired
    lateinit var compraRepository: CompraRepository

    fun getAll(): List<Purchase> {
        return compraRepository.getAll()
    }

    fun getByClient(clientId: String): List<Purchase>? {
        return compraRepository.getByClient(clientId)
    }

    fun save(purchase: Purchase): Purchase {
        return compraRepository.save(purchase)
    }

}