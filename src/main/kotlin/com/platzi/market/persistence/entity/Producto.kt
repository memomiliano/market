package com.platzi.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "productos")
class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    var idProducto: Int = 0

    var nombre: String = ""

    @Column(name = "id_categoria")
    var idCategoria: Int = 0

    @Column(name = "codigo_barras")
    var codigoBarras: String = ""

    @Column(name = "precio_venta")
    var precioVenta: Double = 0.0

    @Column(name = "cantidad_stock")
    var cantidadStock: Int = 0

    var estado: Boolean = true

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    var categoria: Categoria? = null

}