package com.ralphmarondev.spring_note.user.repository

import com.ralphmarondev.spring_note.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}