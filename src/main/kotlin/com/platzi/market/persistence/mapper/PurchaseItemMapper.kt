package com.platzi.market.persistence.mapper

import com.platzi.market.domain.PurchaseItem
import com.platzi.market.persistence.entity.ComprasProducto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

class PurchaseItemMapper {

    fun toPurchaseItem(producto: ComprasProducto): PurchaseItem {
        var purchaseItem: PurchaseItem = PurchaseItem()
        purchaseItem.productId = producto.id!!.idProducto
        purchaseItem.quantity = producto.cantidad
        purchaseItem.active = producto.estado
        purchaseItem.total = producto.total
        return purchaseItem
    }

    fun toComprasProducto(item: PurchaseItem): ComprasProducto {
        var comprasProducto: ComprasProducto = ComprasProducto()
        comprasProducto.id!!.idProducto = item.productId
        comprasProducto.cantidad = item.quantity
        comprasProducto.estado = item.active
        comprasProducto.total = item.total
        return comprasProducto
    }

}