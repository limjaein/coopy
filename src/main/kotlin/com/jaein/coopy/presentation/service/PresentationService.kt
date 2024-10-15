package com.jaein.coopy.presentation.service

import com.jaein.coopy.presentation.dto.IngredientDTO
import com.jaein.coopy.presentation.dto.RecipeDTO
import com.jaein.coopy.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService (
    private val presentationRepository: PresentationRepository
){
    @Transactional(readOnly = true)
    fun getRecipes(): List<RecipeDTO> {
        val recipes = presentationRepository.getRecipes()

        return recipes.map { RecipeDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getIngredients(): List<IngredientDTO> {
        val ingredients = presentationRepository.getIngredients()

        return ingredients.map { IngredientDTO(it) }
    }
}