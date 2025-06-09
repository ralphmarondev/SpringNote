package com.ralphmarondev.springnote.auth.domain.repository

import com.ralphmarondev.springnote.auth.domain.model.TokenPair
import com.ralphmarondev.springnote.core.domain.model.Result

interface AuthRepository {
    suspend fun login(username: String, password: String): TokenPair
    suspend fun register(email: String, password: String)
}