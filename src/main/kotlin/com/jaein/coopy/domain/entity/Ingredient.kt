package com.jaein.coopy.domain.entity

import jakarta.persistence.*

@Entity
class Ingredient(
        name: String,
        userId: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    var id: Long? = null

    var name: String = name

    var userId: String = userId
            
}
