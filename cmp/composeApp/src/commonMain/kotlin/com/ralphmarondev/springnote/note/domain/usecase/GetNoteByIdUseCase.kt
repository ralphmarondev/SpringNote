package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: String): Note {
        return repository.getNoteById(id)
    }
}