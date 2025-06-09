package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.first

class GetAllNotesUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(): List<Note> {
        return repository.getAllNotes().first()
    }
}