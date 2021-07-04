package com.platzi.market.domain

class Product {

    var productId: Int = 0
    var name: String = ""
    var categoryId: Int = 0
    var price: Double = 0.0
    var stock: Int = 0
    var active: Boolean = true
    var category: Category? = null

}