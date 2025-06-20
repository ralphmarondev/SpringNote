package com.ralphmarondev.spring_note.user

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fullName: String,
    @Column(unique = true)
    val email: String,
    val password: String
)