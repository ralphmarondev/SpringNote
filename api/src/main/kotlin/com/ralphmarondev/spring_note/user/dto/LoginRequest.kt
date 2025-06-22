package com.ralphmarondev.spring_note.user.dto

data class LoginRequest(
    val email: String,
    val password: String
)