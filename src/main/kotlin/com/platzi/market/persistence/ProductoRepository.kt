package com.platzi.market.persistence

import com.platzi.market.persistence.crud.ProductoCrudReposiroty
import com.platzi.market.persistence.entity.Producto
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductoRepository {

    var productoCrudReposiroty: ProductoCrudReposiroty? = null

    fun getAll(): List<Producto> {
        return productoCrudReposiroty?.findAll() as List<Producto>
    }

    fun getByCategoria(idCategoria: Int): List<Producto>? {
        return productoCrudReposiroty?.findByIdCategoriaOrderByNombreAsc(idCategoria)
    }

    fun getEscasos(cantidad: Int): List<Producto>? {
        return productoCrudReposiroty?.findByCantidadStockLessThanAndEstado(cantidad, true)
    }

    fun getProducto(idProducto: Int): Optional<Producto> {
        return productoCrudReposiroty!!.findById(idProducto)
    }

    fun saveProducto(producto: Producto): Producto? {
        return productoCrudReposiroty?.save(producto)
    }

    fun deleteProducto(idProducto: Integer) {
        productoCrudReposiroty!!.deleteById(idProducto)
    }

}