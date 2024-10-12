package com.jaein.coopy.domain.repository

import com.jaein.coopy.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}