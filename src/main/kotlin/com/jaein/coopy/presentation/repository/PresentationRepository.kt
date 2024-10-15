package com.jaein.coopy.presentation.repository

import com.jaein.coopy.domain.entity.Ingredient
import com.jaein.coopy.domain.entity.Recipe
import com.jaein.coopy.domain.repository.IngredientRepository
import com.jaein.coopy.domain.repository.RecipeRepository
import com.jaein.coopy.domain.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository (
    private val ingredientRepository: IngredientRepository,
    private val recipeRepository: RecipeRepository,
    private val userRepository: UserRepository
) {
    fun getIngredients(): List<Ingredient> {
        return ingredientRepository.findAll()
    }

    fun getRecipes(): List<Recipe> {
        return recipeRepository.findAll()
    }

}