package com.platzi.market.persistence.mapper

import com.platzi.market.domain.Product
import com.platzi.market.domain.Purchase
import com.platzi.market.domain.PurchaseItem
import com.platzi.market.persistence.entity.Compra
import com.platzi.market.persistence.entity.ComprasProducto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

class PurchaseMapper {

    var purchaseItemMapper: PurchaseItemMapper = PurchaseItemMapper()

    fun toPurchase(compra: Compra): Purchase{
        var purchase: Purchase = Purchase()
        purchase.purchaseId     = compra.idCompra
        purchase.clientId       = compra.idCliente
        purchase.date           = compra.fecha
        purchase.paymentMethod  = compra.medioPago
        purchase.comment        = compra.comentario
        purchase.state          = compra.estado
        var items: ArrayList<PurchaseItem> = arrayListOf()
        compra.productos?.forEach{
            items.add(purchaseItemMapper.toPurchaseItem(it))
        }
        purchase.items = items
        return purchase
    }

    fun toPurchases(compras: List<Compra>): List<Purchase>{
        var purchases: MutableList<Purchase> = mutableListOf()
        compras.forEach {
            purchases.add(this.toPurchase(it))
        }
        return purchases as List<Purchase>
    }

    fun toCompra(purchase: Purchase): Compra{
        var compra: Compra = Compra()
        compra.idCompra     = purchase.purchaseId
        compra.idCliente    = purchase.clientId
        compra.fecha        = purchase.date
        compra.medioPago    = purchase.paymentMethod
        compra.comentario   = purchase.comment
        compra.estado       = purchase.state
        var productos: ArrayList<ComprasProducto> = arrayListOf()
        purchase.items?.forEach{
            productos.add(purchaseItemMapper.toComprasProducto(it))
        }
        compra.productos = productos
        return compra
    }

}