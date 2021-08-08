package com.platzi.market.persistence.crud

import com.platzi.market.persistence.entity.Compra
import org.springframework.data.repository.CrudRepository

interface CompraCrudRepository: CrudRepository<Compra, Int> {

    fun findByIdCliente(idCliente: String): List<Compra>?

}