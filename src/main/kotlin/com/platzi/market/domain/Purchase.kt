package com.platzi.market.domain

import java.time.LocalDateTime

class Purchase {
        var purchaseId: Int = 0
        var clientId: String = ""
        var date: LocalDateTime = LocalDateTime.now()
        var paymentMethod: String = ""
        var comment: String = ""
        var state: String = ""
        var items: List<PurchaseItem>? = null
}