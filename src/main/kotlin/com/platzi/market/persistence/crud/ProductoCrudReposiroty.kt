package com.platzi.market.persistence.crud

import com.platzi.market.persistence.entity.Producto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductoCrudReposiroty: CrudRepository<Producto,Int> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    fun findByIdCategoriaOrderByNombreAsc(idCategoria: Int): List<Producto>

    fun findByCantidadStockLessThanAndEstado(cantidadStock: Int, estado: Boolean): List<Producto>

}