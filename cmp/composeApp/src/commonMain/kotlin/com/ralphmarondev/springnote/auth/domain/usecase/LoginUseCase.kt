package com.ralphmarondev.springnote.auth.domain.usecase

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.ralphmarondev.springnote.auth.domain.repository.AuthRepository
import com.ralphmarondev.springnote.core.data.local.ACCESS_TOKEN_KEY
import com.ralphmarondev.springnote.core.data.local.REFRESH_TOKEN_KEY
import com.ralphmarondev.springnote.core.domain.model.Result

class LoginUseCase(
    private val repository: AuthRepository,
    private val dataStore: DataStore<Preferences>
) {
    suspend operator fun invoke(username: String, password: String): Result {

        if (username.isBlank() && password.isBlank()) {
            return Result(
                success = false,
                message = "Username and password cannot be empty."
            )
        }
        if (username.isBlank()) {
            return Result(
                success = false,
                message = "Username cannot be empty."
            )
        }
        if (password.isBlank()) {
            return Result(
                success = false,
                message = "Password cannot be empty."
            )
        }

        return try {
            val tokenPair = repository.login(username, password)
            if (tokenPair.access.isBlank() || tokenPair.refresh.isBlank()) {
                return Result(
                    success = false,
                    message = "Tokens cannot be blank."
                )
            }
            println("Access token: ${tokenPair.access}")
            println("Refresh token: ${tokenPair.refresh}")

            dataStore.edit {
                it[ACCESS_TOKEN_KEY] = tokenPair.access
                it[REFRESH_TOKEN_KEY] = tokenPair.refresh
            }

            Result(
                success = true,
                message = "Login successful."
            )
        } catch (e: Exception) {
            println("Error: ${e.message}")
            Result(
                success = false,
                message = "Unexpected error occurred."
            )
        }
    }
}