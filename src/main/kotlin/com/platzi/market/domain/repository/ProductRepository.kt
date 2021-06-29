package com.platzi.market.domain.repository

import com.platzi.market.domain.Product
import java.util.*

interface ProductRepository {
    fun getAll(): List<Product>
    fun getByCategory(categoryId: Int): List<Product>?
    fun getScarseProducts(quantity: Int): List<Product>?
    fun getProduct(productId: Int): Product?
    fun save(product: Product): Product
    fun delete(productId: Int)
}