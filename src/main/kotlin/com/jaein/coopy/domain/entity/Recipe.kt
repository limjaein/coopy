package com.jaein.coopy.domain.entity;

import jakarta.persistence.*;

@Entity
class Recipe(
        name: String,
        description: String,
        user_id: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var user_id: String = user_id

    @OneToMany
    val RecipeIngredients: MutableList<RecipeIngredient> = arrayListOf()
}
