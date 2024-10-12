package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long> {
}