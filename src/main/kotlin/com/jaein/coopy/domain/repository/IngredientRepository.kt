package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<Ingredient, Long> {

    fun findAllByName(name: String)
}