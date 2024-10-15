package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RecipeRepository : JpaRepository<Recipe, Long> {

    /**
     * 이름 검색을 통한 레시피 조회
     */
    fun findAllByName(name: String): List<Recipe>

    /**
     * 특정 사용자가 만든 레시피 조회
     */
    fun findAllByUserId(userId: String): List<Recipe>

}