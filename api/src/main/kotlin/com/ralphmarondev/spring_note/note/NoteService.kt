package com.ralphmarondev.spring_note.note

import org.springframework.stereotype.Service

@Service
class NoteService(
    private val repository: NoteRepository
) {

    fun createNote(note: Note): Note {
        return repository.save(note)
    }

    fun getNotes(ownerId: Long): List<Note> {
        return repository.findAllByOwnerIdAndIsDeletedFalseOrderByCreateDateDesc(ownerId)
    }

    fun deleteNote(noteId: Long, ownerId: Long): Boolean {
        val note = repository.findById(noteId).orElse(null)

        if (note != null && note.ownerId == ownerId) {
            val updated = note.copy(isDeleted = true)
            repository.save(updated)
            return true
        }
        return false
    }
}