package com.ralphmarondev.spring_note.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val service: UserService
) {

    data class LoginRequest(
        val email: String,
        val password: String
    )

    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<User> {
        val registeredUser = service.register(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<User> {
        val loggedInUser = service.login(email = request.email, password = request.password)
        return ResponseEntity.ok(loggedInUser)
    }
}