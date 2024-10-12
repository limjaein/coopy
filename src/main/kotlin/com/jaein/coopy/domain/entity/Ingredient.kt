package com.jaein.coopy.domain.entity;

import jakarta.persistence.*;

@Entity
class Ingredient(
        name: String,
        user_id: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long? = null

    var name: String = name

    var user_id: String = user_id

    @OneToMany
    val RecipeIngredients: MutableList<RecipeIngredient> = arrayListOf()
            
}
