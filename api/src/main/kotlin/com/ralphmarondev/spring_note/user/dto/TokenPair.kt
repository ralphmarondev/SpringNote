package com.ralphmarondev.spring_note.user.dto

data class TokenPair(
    val accessToken: String,
    val refreshToken: String
)