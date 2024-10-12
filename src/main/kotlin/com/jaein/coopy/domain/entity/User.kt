package com.jaein.coopy.domain.entity

import jakarta.persistence.*

@Entity
class User(
        email: String,
        password: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long? = null

    var email: String = email

    var password: String = password
}
