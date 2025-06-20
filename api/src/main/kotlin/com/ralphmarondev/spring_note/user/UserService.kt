package com.ralphmarondev.spring_note.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {
    fun register(user: User): User {
        if (repository.findByEmail(user.email).isPresent) {
            throw IllegalArgumentException("Email already in use.")
        }
        return repository.save(user)
    }

    fun login(email: String, password: String): User {
        val user = repository.findByEmail(email)
            .orElseThrow { IllegalArgumentException("Invalid email or password") }

        if (user.password != password) {
            throw IllegalArgumentException("Invalid email or password")
        }
        return user
    }
}