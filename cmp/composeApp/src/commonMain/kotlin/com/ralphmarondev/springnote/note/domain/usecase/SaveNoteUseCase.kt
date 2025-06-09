package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.core.domain.model.Result
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository

class SaveNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(title: String, content: String): Result {
        if (title.isBlank() && content.isBlank()) {
            return Result(
                success = false,
                message = "Title and content cannot be empty."
            )
        }

        if (title.isBlank()) {
            return Result(
                success = false,
                message = "Title cannot be empty."
            )
        }

        if (content.isBlank()) {
            return Result(
                success = false,
                message = "Content cannot be empty."
            )
        }

        return try {
            val note = repository.saveNote(
                title = title,
                content = content
            )
            if (note.id.isBlank()) {
                Result(
                    success = false,
                    message = "Saving note failed."
                )
            } else {
                Result(
                    success = true,
                    message = "Note saved successfully."
                )
            }
        } catch (e: Exception) {
            println("Error saving note: ${e.message}")
            Result(
                success = false,
                message = "Unexpected error occurred."
            )
        }
    }
}