package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.Recipe
import com.jaein.coopy.domain.entity.RecipeIngredient
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeIngredentRepository : JpaRepository<RecipeIngredient, Long> {
}