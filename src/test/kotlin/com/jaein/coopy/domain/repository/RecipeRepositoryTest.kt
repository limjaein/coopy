package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.Ingredient
import com.jaein.coopy.domain.entity.Recipe
import com.jaein.coopy.domain.entity.RecipeIngredient
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecipeRepositoryTest (
    @Autowired val recipeRepository: RecipeRepository,
    @Autowired val ingredientRepository: IngredientRepository
) {

    val DATA_SIZE = 2

    private fun createRecipe(n: Int): Recipe {
        val recipe = Recipe(
            name = "${n}",
            description = "테스트 설명 ${n}",
            userId = "1"
        )

        val ingredients = ingredientRepository.findAll()
        val ingredientsUsedIdRecipe = ingredients.subList(0, n)
        for (ingredient in ingredientsUsedIdRecipe) {
            val recipeIngredient = RecipeIngredient(recipe = recipe, ingredient = ingredient, price = 1000, amount = "1", measure = "개")
            recipe.ingredients.add(recipeIngredient)
        }

        return recipe
    }

    @BeforeAll
    fun beforeAll() {
        println("----- 재료 데이터 초기화 시작 -----")
        val ingredients = mutableListOf<Ingredient>()
        for (i in 1..DATA_SIZE) {
            val ingredient = Ingredient(name = "테스트 ${i}", userId = "1")
            ingredients.add(ingredient)
        }

        ingredientRepository.saveAll(ingredients)
        println("----- 재료 데이터 초기화 종료 -----")

        println("----- 데이터 초기화 이전 조회 시작 -----")
        val beforeInsert = recipeRepository.findAll()
        assertThat(beforeInsert).hasSize(0)
        println("----- 데이터 초기화 이전 조회 종료 -----")

        println("----- 테스트 데이터 초기화 시작 -----")
        val recipes = mutableListOf<Recipe>()
        for (i in 1..DATA_SIZE) {
            val recipe = createRecipe(i)
            recipes.add(recipe)
        }
        recipeRepository.saveAll(recipes)
        println("----- 테스트 데이터 초기화 종료 -----")
    }

    @Test
    fun testFindAll() {
        println("----- FindAll 테스트 시작 -----")
        val recipes = recipeRepository.findAll()
        assertThat(recipes).hasSize(DATA_SIZE)
        println("recipes.size: ${recipes.size}")

        for (recipe in recipes) {
            assertThat(recipe.ingredients).hasSize(recipe.name.toInt())
            println("recipe.ingredients.size: ${recipe.ingredients.size}")
        }
        println("----- FindAll 테스트 종료 -----")
    }
}