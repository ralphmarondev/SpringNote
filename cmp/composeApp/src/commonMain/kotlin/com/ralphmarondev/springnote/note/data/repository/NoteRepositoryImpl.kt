package com.ralphmarondev.springnote.note.data.repository

import com.ralphmarondev.springnote.note.data.model.NoteRequest
import com.ralphmarondev.springnote.note.data.network.NoteApiService
import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl(
    private val apiService: NoteApiService
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return flow {
            val notesData = apiService.getAllNotes()
            val notes = notesData.map {
                Note(
                    id = it.id,
                    title = it.title,
                    content = it.content,
                    color = it.color,
                    createdAt = it.createdAt
                )
            }
            emit(notes)
        }.catch { e ->
            emit(emptyList())
        }
    }

    override suspend fun getNoteById(id: String): Note {
        val response = apiService.getNoteById(id)
        val note = Note(
            id = response.id,
            title = response.title,
            content = response.content,
            color = response.color,
            createdAt = response.createdAt
        )
        return note
    }

    override suspend fun saveNote(title: String, content: String): Note {
        val response = apiService.saveNote(
            noteRequest = NoteRequest(
                title = title,
                content = content,
                color = 1
            )
        )
        val note = Note(
            id = response.id,
            title = response.title,
            content = response.content,
            color = response.color,
            createdAt = response.createdAt
        )
        return note
    }

    override suspend fun updateNote(note: Note): Note {
        val response = apiService.updateNote(
            id = note.id,
            noteRequest = NoteRequest(
                title = note.title,
                content = note.content,
                color = note.color
            )
        )
        val newNote = Note(
            id = response.id,
            title = response.title,
            content = response.content,
            color = response.color,
            createdAt = response.createdAt
        )
        return newNote
    }

    override suspend fun deleteNoteById(id: String) {
        apiService.deleteNoteById(id)
    }
}