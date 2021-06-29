package com.platzi.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "compras_producto")
//@IdClass(ComprasProductoPK::class)
class ComprasProducto{

    //@Id var idCompra: Int = 0
    //@Id var idProducto: Int = 0

    @EmbeddedId
    var id: ComprasProductoPK? = null

    var cantidad: Int = 0
    var total: Double = 0.0
    var estado: Boolean = true

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    var compra: Compra? = null

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    var producto: Producto? = null

}