package com.ralphmarondev.springnote.note.data.repository

import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NoteRepositoryImpl : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        val sampleNotes = listOf(
            Note(
                id = "1",
                title = "Hello",
                content = "Sample content",
                color = 2,
                createdAt = "2025-06-08"
            ),
            Note(
                id = "2",
                title = "Hi there",
                content = "Ralph Maron Eda is here!",
                color = 2,
                createdAt = "2025-06-09"
            )
        )
        return flowOf(sampleNotes)
    }
}