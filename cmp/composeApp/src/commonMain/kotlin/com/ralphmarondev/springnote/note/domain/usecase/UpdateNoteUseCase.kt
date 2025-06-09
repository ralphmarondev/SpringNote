package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.core.domain.model.Result
import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note): Result {
        if (note.id.isBlank()) {
            return Result(
                success = false,
                message = "Updating note failed. Blank id."
            )
        }
        if (note.title.isBlank()) {
            return Result(
                success = false,
                message = "Title cannot be empty."
            )
        }
        if (note.content.isBlank()) {
            return Result(
                success = false,
                message = "Content cannot be empty."
            )
        }

        return try {
            val response = repository.updateNote(note)

            if (response.id.isBlank()) {
                Result(
                    success = false,
                    message = "Updating note failed."
                )
            } else {
                Result(
                    success = true,
                    message = "Note updated successfully."
                )
            }
        } catch (e: Exception) {
            Result(
                success = false,
                message = "Updating note failed. Error: ${e.message}"
            )
        }
    }
}