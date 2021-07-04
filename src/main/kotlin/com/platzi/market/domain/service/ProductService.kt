package com.platzi.market.domain.service

import com.platzi.market.domain.Product
import com.platzi.market.domain.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun getAll(): List<Product> {
        return productRepository.getAll()
    }

    fun getProduct(productId: Int): Product? {
        return productRepository.getProduct(productId)
    }

    fun getByCategory(categoryId: Int): List<Product>? {
        return productRepository.getByCategory(categoryId)
    }

    fun save(product: Product): Product {
        return productRepository.save(product)
    }

    fun delete(productId: Int): Boolean{
        var produc: Product? = getProduct(productId)
        return if(produc != null){
            productRepository.delete(productId)
            true
        }else{
            false
        }
    }

}