package com.platzi.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "clientes")
class Cliente{

    @Id
    var id: String = ""
    var nombre: String = ""
    var apellidos: String = ""
    var celular: Int = 0
    var direccion: String = ""

    @Column(name = "correo_electronico")
    var correoElectronico: String = ""

    @OneToMany(mappedBy = "cliente")
    var compras: List<Compra>? = null
}