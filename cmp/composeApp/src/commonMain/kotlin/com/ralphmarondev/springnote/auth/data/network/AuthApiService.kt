package com.ralphmarondev.springnote.auth.data.network

import com.ralphmarondev.springnote.auth.data.model.AuthRequest
import com.ralphmarondev.springnote.auth.data.model.TokenPair
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

private const val BASE_URL = "http://192.168.68.114:8085/auth"

class AuthApiService(
    private val httpClient: HttpClient
) {
    suspend fun login(authRequest: AuthRequest): TokenPair {
        return httpClient.post("$BASE_URL/login") {
            setBody(authRequest)
        }.body()
    }
}