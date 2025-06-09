package com.ralphmarondev.springnote.auth.data.network

import com.ralphmarondev.springnote.auth.data.model.AuthRequest
import com.ralphmarondev.springnote.auth.data.model.TokenPair
import com.ralphmarondev.springnote.core.util.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class AuthApiService(
    private val httpClient: HttpClient
) {
    suspend fun login(authRequest: AuthRequest): TokenPair {
        return httpClient.post("$BASE_URL/auth/login") {
            setBody(authRequest)
        }.body()
    }

    suspend fun register(authRequest: AuthRequest) {
        httpClient.post("$BASE_URL/auth/register") {
            setBody(authRequest)
        }
    }
}