package com.platzi.market.web.controller

import com.platzi.market.domain.Product
import com.platzi.market.domain.Purchase
import com.platzi.market.domain.service.PurchaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchases")
class PurchaseController {

    @Autowired
    lateinit var purchaseService: PurchaseService

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<Purchase>> {
        return ResponseEntity(purchaseService?.getAll(), HttpStatus.OK)
    }

    @GetMapping("/client/{clientId}")
    fun getByClient(@PathVariable clientId: String): ResponseEntity<List<Purchase>> {
        purchaseService?.getByClient(clientId)
                ?.let{ return ResponseEntity(it, HttpStatus.OK) }
                .also { return ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @PostMapping("/save")
    fun save(@RequestBody purchase: Purchase): ResponseEntity<Purchase> {
        return ResponseEntity(purchaseService!!.save(purchase),HttpStatus.CREATED)
    }

}