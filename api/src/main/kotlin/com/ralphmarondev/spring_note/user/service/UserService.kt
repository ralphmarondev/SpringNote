package com.ralphmarondev.spring_note.user.service

import com.ralphmarondev.spring_note.security.JwtService
import com.ralphmarondev.spring_note.user.dto.TokenPair
import com.ralphmarondev.spring_note.user.entity.User
import com.ralphmarondev.spring_note.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val jwtService: JwtService
) {
    fun register(user: User): TokenPair {
        if (repository.findByEmail(user.email) != null) {
            throw IllegalArgumentException("Email already in use.")
        }
        repository.save(user)

        val accessToken = jwtService.generateAccessToken(user.email)
        val refreshToken = jwtService.generateRefreshToken(user.email)

        return TokenPair(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun login(email: String, password: String): TokenPair {
        val user = repository.findByEmail(email)
            ?: throw IllegalArgumentException("Invalid email or password")

        if (user.password != password) {
            throw IllegalArgumentException("Invalid email or password")
        }

        val accessToken = jwtService.generateAccessToken(user.email)
        val refreshToken = jwtService.generateRefreshToken(user.email)

        return TokenPair(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun refreshAccessToken(refreshToken: String): String {
        val email = jwtService.extractEmailFromRefresh(refreshToken)
            ?: throw IllegalArgumentException("Invalid refresh token.")

        if (!jwtService.isRefreshTokenValid(refreshToken, email)) {
            throw RuntimeException("Invalid or expired refresh token")
        }
        return jwtService.generateAccessToken(email)
    }
}