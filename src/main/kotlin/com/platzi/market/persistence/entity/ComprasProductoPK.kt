package com.platzi.market.persistence.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ComprasProductoPK: Serializable {

    @Column(name = "id_compra")
    var idCompra: Int = 0

    @Column(name = "id_producto")
    var idProducto: Int = 0

}