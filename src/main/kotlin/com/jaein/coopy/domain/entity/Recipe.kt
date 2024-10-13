package com.jaein.coopy.domain.entity

import jakarta.persistence.*

@Entity
class Recipe(
        name: String,
        description: String,
        userId: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var userId: String = userId

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    var ingredients: MutableList<RecipeIngredient> = mutableListOf()

    fun update(name: String, description: String) {
        this.name = name
        this.description = description
    }

    fun addIngredients(ingredients: MutableList<RecipeIngredient>?) {
        if (ingredients != null) {
            this.ingredients.addAll(ingredients)
        }
    }
}
