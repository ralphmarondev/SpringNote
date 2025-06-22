package com.ralphmarondev.spring_note.user.controller

import com.ralphmarondev.spring_note.user.dto.LoginRequest
import com.ralphmarondev.spring_note.user.dto.TokenPair
import com.ralphmarondev.spring_note.user.entity.User
import com.ralphmarondev.spring_note.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val service: UserService
) {

    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<Any> {
        try {
            val token = service.register(user)
            return ResponseEntity.ok(TokenPair(token.accessToken, token.refreshToken))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(e.message)
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        try {
            val token = service.login(
                email = request.email,
                password = request.password
            )
            return ResponseEntity.ok(TokenPair(token.accessToken, token.refreshToken))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(e.message)
        }
    }
}