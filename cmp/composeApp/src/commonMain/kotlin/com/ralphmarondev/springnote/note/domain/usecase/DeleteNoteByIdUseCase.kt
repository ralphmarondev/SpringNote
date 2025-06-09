package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.core.domain.model.Result
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository

class DeleteNoteByIdUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: String): Result {
        return try {
            repository.deleteNoteById(id)
            Result(
                success = true,
                message = "Note deleted successfully!"
            )
        } catch (e: Exception) {
            println("Error deleting note: ${e.message}")
            Result(
                success = false,
                message = "Failed to delete note. unknown error occurred."
            )
        }
    }
}