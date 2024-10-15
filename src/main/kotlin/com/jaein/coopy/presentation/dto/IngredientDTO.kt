package com.jaein.coopy.presentation.dto

import com.jaein.coopy.domain.entity.Ingredient

data class IngredientDTO (
        val name: String,
        val userId: String
) {
    constructor(ingredient: Ingredient) : this(
        name = ingredient.name,
        userId = ingredient.userId
    )
}