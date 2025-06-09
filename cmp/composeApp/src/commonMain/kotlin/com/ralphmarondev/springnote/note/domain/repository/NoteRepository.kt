package com.ralphmarondev.springnote.note.domain.repository

import com.ralphmarondev.springnote.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>
}