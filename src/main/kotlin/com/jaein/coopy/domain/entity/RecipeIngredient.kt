package com.jaein.coopy.domain.entity;

import jakarta.persistence.*;

@Table(name = "Recipe_Ingredient")
@Entity
class RecipeIngredient (
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    var recipeId: Recipe,

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    var ingredientId: Ingredient,

    var price: Int,

    var amount: String,

    var measure: String

) : BaseEntity() {

}