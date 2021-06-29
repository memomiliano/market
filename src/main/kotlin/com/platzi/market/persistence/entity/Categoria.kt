package com.platzi.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "categorias")
class Categoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    var idCategoria: Int = 0

    var descripcion: String = ""

    var estado: Boolean = true

    @OneToMany(mappedBy = "categoria")
    var productos: List<Producto>? = null

}