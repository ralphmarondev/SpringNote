package com.ralphmarondev.springnote.auth.domain.usecase

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ralphmarondev.springnote.auth.domain.repository.AuthRepository
import com.ralphmarondev.springnote.core.domain.model.Result

class RegisterUseCase(
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