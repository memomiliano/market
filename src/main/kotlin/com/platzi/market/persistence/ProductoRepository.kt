package com.platzi.market.persistence

import com.platzi.market.domain.Product
import com.platzi.market.domain.repository.ProductRepository
import com.platzi.market.persistence.crud.ProductoCrudReposiroty
import com.platzi.market.persistence.entity.Producto
import com.platzi.market.persistence.mapper.ProductMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductoRepository: ProductRepository {

    @Autowired
    lateinit var productoCrudReposiroty: ProductoCrudReposiroty

    var mapper: ProductMapper = ProductMapper()

    @Override
    override fun getAll(): List<Product> {
        var productos: List<Producto> = productoCrudReposiroty!!.findAll() as List<Producto>
        //productos.forEach { println(it.nombre) }
        return mapper.toProducts(productos)
    }

    override fun getByCategory(categoryId: Int): List<Product>? {
        var productos: List<Producto> = productoCrudReposiroty!!.findByIdCategoriaOrderByNombreAsc(categoryId) as List<Producto>
        return mapper?.toProducts(productos)
    }

    override fun getScarseProducts(quantity: Int): List<Product>? {
        var productos: List<Producto>? = productoCrudReposiroty?.findByCantidadStockLessThanAndEstado(quantity,true)
        return productos?.map { n -> mapper!!.toProduct(n) }
    }

    override fun getProduct(productId: Int): Product? {
        var producto: Optional<Producto> = productoCrudReposiroty.findById(productId)
        var product: Product? = null
        producto.ifPresent {
            product =  mapper?.toProduct(it)
        }
        return product
    }

    override fun save(product: Product): Product {
        var producto: Producto = mapper!!.toProducto(product)
        return mapper!!.toProduct(productoCrudReposiroty!!.save(producto))
    }

    override fun delete(productId: Int) {
        productoCrudReposiroty!!.deleteById(productId)
    }

}