package com.platzi.market.persistence.mapper

import com.platzi.market.domain.Category
import com.platzi.market.persistence.entity.Categoria

class CategoryMapper {

    fun toCategory(categoria: Categoria): Category {
        var category: Category = Category()
        category.categoryId = categoria.idCategoria
        category.category = categoria.descripcion
        category.active = categoria.estado
        return category
    }

    fun toCategoria(category: Category): Categoria {
        var categoria: Categoria = Categoria()
        categoria.idCategoria = category.categoryId
        categoria.descripcion = category.category
        categoria.estado = category.active
        return categoria
    }
}