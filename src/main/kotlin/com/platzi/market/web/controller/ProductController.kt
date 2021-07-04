package com.platzi.market.web.controller

import com.platzi.market.domain.Product
import com.platzi.market.domain.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/all")
    fun getAll(): List<Product>? {
        return productService?.getAll()
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Int): Product? {
        return productService?.getProduct(productId)
    }

    @GetMapping("/category/{categoryId}")
    fun getByCategory(@PathVariable categoryId: Int): List<Product>? {
        return productService?.getByCategory(categoryId)
    }

    @PostMapping("/save")
    fun save(@RequestBody product: Product): Product {
        return productService!!.save(product)
    }

    @DeleteMapping("/delete/{productId}")
    fun delete(@PathVariable productId: Int): Boolean? {
        return productService?.delete(productId)
    }

}