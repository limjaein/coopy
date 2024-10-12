package com.jaein.coopy.domain.entity

import jakarta.persistence.*

@Table(name = "Recipe_Ingredient")
@Entity
class RecipeIngredient (recipe: Recipe, ingredient: Ingredient,
    price: Int,
    amount: String,
    measure: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredient_id")
    var id: Long? = null

    @ManyToOne(targetEntity = Recipe::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    var recipe: Recipe = recipe

    @ManyToOne(targetEntity = Ingredient::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    var ingredient: Ingredient = ingredient

    var price: Int = price

    var amount: String = amount

    var measure: String = measure
}