package com.platzi.market.persistence.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "compras")
class Compra{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    var idCompra: Int = 0

    @Column(name = "id_cliente")
    var idCliente: String = ""

    var fecha: LocalDateTime = LocalDateTime.now()

    @Column(name = "medio_pago")
    var medioPago: String = ""

    var comentario: String = ""

    var estado: String = ""

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    var cliente: Cliente? = null

    @OneToMany(mappedBy = "producto")
    var productos: List<ComprasProducto>? = null

}