package com.jaein.coopy.domain

import com.jaein.coopy.domain.entity.Ingredient
import com.jaein.coopy.domain.entity.Recipe
import com.jaein.coopy.domain.entity.RecipeIngredient
import com.jaein.coopy.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile(value = ["default"])
class DataInitializer (
    private val ingredientRepository: IngredientRepository,
    private val recipeRepository: RecipeRepository,
    private val recipeIngredentRepository: RecipeIngredentRepository,
    private val userRepository: UserRepository
) {

    @PostConstruct
    fun initailizeData() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val ingredient1 = Ingredient(
            name = "마늘",
            userId = "1"
        )

        val ingredient2 = Ingredient(
            name = "파스타",
            userId = "2"
        )

        val ingredient3 = Ingredient(
            name = "토마토소스",
            userId = "3"
        )

        val ingredients = mutableListOf<Ingredient>(
            ingredient1, ingredient2, ingredient3
        )

        ingredientRepository.saveAll(ingredients)

        val recipe1 = Recipe(
            name = "알리오올리오",
            description = "마늘이 주재료인 오일파스타",
            userId = "1"
        )

        val recipe2 = Recipe(
            name = "토마토파스타",
            description = "토마토 소스로 만드는 파스타",
            userId = "3"
        )

        // 추가방법1
        recipe1.addIngredients(
            mutableListOf(
                RecipeIngredient(recipe1, ingredient1, 1000, "10", "알"),
                RecipeIngredient(recipe1, ingredient2, 2000, "200", "g")
            )
        )

        // 추가방법2
        recipe2.ingredients.addAll(
            mutableListOf(
                RecipeIngredient(recipe2, ingredient1, 1000, "10", "알"),
                RecipeIngredient(recipe2, ingredient2, 2000, "200", "g"),
                RecipeIngredient(recipe2, ingredient3, 5000, "300", "g")
            )
        )

        recipeRepository.saveAll(mutableListOf(recipe1, recipe2))

    }
}