package com.jaein.coopy.presentation.dto

import com.jaein.coopy.domain.entity.Recipe

data class RecipeDTO (
    val name: String,
    val description: String,
    val ingredients: List<IngredientDTO>,
    val userId: String
) {
    constructor(recipe: Recipe) : this(
        name = recipe.name,
        description = recipe.description,
        ingredients = recipe.ingredients.map { it.ingredient }.map { IngredientDTO(it) },
        userId = recipe.userId
    )
}