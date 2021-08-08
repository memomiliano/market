package com.platzi.market.web.controller

import com.platzi.market.domain.Product
import com.platzi.market.domain.service.ProductService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/all")
    @ApiOperation("Get all supermarket product")
    @ApiResponse(code = 200, message = "OK")
    fun getAll(): ResponseEntity<List<Product>> {
        return ResponseEntity(productService?.getAll(), HttpStatus.OK)
    }

    @GetMapping("/{productId}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 404, message = "Product not found")
    )
    fun getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
                   @PathVariable productId: Int): ResponseEntity<Product> {
        productService.getProduct(productId)
                ?.let{ return ResponseEntity(it, HttpStatus.OK) }
                .also { return ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @GetMapping("/category/{categoryId}")
    fun getByCategory(@PathVariable categoryId: Int): ResponseEntity<List<Product>> {
        productService?.getByCategory(categoryId)
                ?.let{ return ResponseEntity(it, HttpStatus.OK) }
                .also { return ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @PostMapping("/save")
    fun save(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService!!.save(product),HttpStatus.CREATED)
    }

    @DeleteMapping("/delete/{productId}")
    fun delete(@PathVariable productId: Int): ResponseEntity<Any> {
        val delete = productService?.delete(productId)
        return if(delete){
            ResponseEntity(HttpStatus.OK)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

}