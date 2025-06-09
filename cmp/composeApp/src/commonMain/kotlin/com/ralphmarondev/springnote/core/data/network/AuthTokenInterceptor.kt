package com.ralphmarondev.springnote.core.data.network

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ralphmarondev.springnote.core.data.local.ACCESS_TOKEN_KEY
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.HttpHeaders
import io.ktor.http.encodedPath
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class AuthTokenInterceptor(
    private val dataStore: DataStore<Preferences>
) {
    val plugin = createClientPlugin("AuthTokenInterceptor", ::Config) {
        onRequest { request, _ ->
            val path = request.url.encodedPath
            val isAuthPath = path.contains("/auth/login") || path.contains("/auth/register")

            if (!isAuthPath) {
                val token = runBlocking {
                    try {
                        dataStore.data.first()[ACCESS_TOKEN_KEY]
                    } catch (e: Exception) {
                        null
                    }
                }

                token?.let {
                    request.headers.append(HttpHeaders.Authorization, "Bearer $it")
                }
            }
        }
    }

    class Config
}