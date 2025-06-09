package com.ralphmarondev.springnote.note.domain.repository

import com.ralphmarondev.springnote.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: String): Note

    suspend fun saveNote(title: String, content: String): Note

    suspend fun deleteNoteById(id: String)
}