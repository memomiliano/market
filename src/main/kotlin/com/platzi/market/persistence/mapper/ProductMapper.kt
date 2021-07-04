package com.platzi.market.persistence.mapper

import com.platzi.market.domain.Product
import com.platzi.market.persistence.mapper.CategoryMapper
import com.platzi.market.persistence.entity.Producto
import org.mapstruct.*
import org.springframework.stereotype.Component

class ProductMapper {

    var categoryMapper: CategoryMapper = CategoryMapper()

    fun toProduct(producto: Producto): Product {
        var product: Product = Product()
        product.productId = producto.idProducto
        product.name = producto.nombre
        product.categoryId = producto.idCategoria
        product.price = producto.precioVenta
        product.stock = producto.cantidadStock
        product.active = producto.estado
        product.category = producto.categoria?.let { categoryMapper.toCategory(it) }
        return product
    }

    fun toProducts(productos: List<Producto>): List<Product> {
        var products: MutableList<Product> = mutableListOf()
        productos.forEach {
            products.add(this.toProduct(it))
        }
        return products as List<Product>
    }

    fun toProducto(product: Product): Producto {
        var producto: Producto = Producto()
        producto.idProducto = product.productId
        producto.nombre = product.name
        producto.idCategoria = product.categoryId
        producto.precioVenta = product.price
        producto.cantidadStock = product.stock
        producto.estado = product.active
        producto.categoria = product.category?.let { categoryMapper.toCategoria(it) }
        return producto
    }


}