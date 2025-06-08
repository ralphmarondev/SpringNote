package com.ralphmarondev.springnote.auth.data.repository

import com.ralphmarondev.springnote.auth.domain.model.TokenPair
import com.ralphmarondev.springnote.auth.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(username: String, password: String): TokenPair {
        return TokenPair(
            access = "access",
            refresh = "refresh"
        )
    }
}