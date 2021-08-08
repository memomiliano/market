package com.platzi.market.persistence

import com.platzi.market.domain.Purchase
import com.platzi.market.domain.repository.PurchaseRepository
import com.platzi.market.persistence.crud.CompraCrudRepository
import com.platzi.market.persistence.entity.Compra
import com.platzi.market.persistence.mapper.PurchaseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CompraRepository: PurchaseRepository{

    @Autowired
    lateinit var compraCrudRepository: CompraCrudRepository

    var mapper: PurchaseMapper = PurchaseMapper()

    override fun getAll(): List<Purchase> {
        return mapper.toPurchases(compraCrudRepository.findAll() as List<Compra>)
    }

    override fun getByClient(clientId: String): List<Purchase>? {
        return compraCrudRepository.findByIdCliente(clientId)?.map { compra -> mapper.toPurchase(compra) }
    }

    override fun save(purchase: Purchase): Purchase {
        var compra: Compra = mapper.toCompra(purchase)
        compra.productos?.forEach {
            it.compra = compra
        }
        return mapper.toPurchase(compraCrudRepository.save(compra))
    }


}