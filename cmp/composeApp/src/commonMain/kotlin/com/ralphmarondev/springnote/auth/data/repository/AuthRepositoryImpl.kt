package com.ralphmarondev.springnote.auth.data.repository

import com.ralphmarondev.springnote.auth.data.model.AuthRequest
import com.ralphmarondev.springnote.auth.data.network.AuthApiService
import com.ralphmarondev.springnote.auth.domain.model.TokenPair
import com.ralphmarondev.springnote.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authApiService: AuthApiService
) : AuthRepository {
    override suspend fun login(username: String, password: String): TokenPair {
        val response = authApiService.login(
            authRequest = AuthRequest(
                email = username,
                password = password
            )
        )
        return TokenPair(
            access = response.accessToken,
            refresh = response.refreshToken
        )
    }
}