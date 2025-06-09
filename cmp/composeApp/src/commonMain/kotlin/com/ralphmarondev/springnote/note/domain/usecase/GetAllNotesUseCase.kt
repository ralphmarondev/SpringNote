package com.ralphmarondev.springnote.note.domain.usecase

import com.ralphmarondev.springnote.note.domain.repository.NoteRepository

class GetAllNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke() = repository.getAllNotes()
}