package com.ralphmarondev.springnote.auth.domain.repository

import com.ralphmarondev.springnote.auth.domain.model.TokenPair

interface AuthRepository {
    suspend fun login(username: String, password: String): TokenPair
}