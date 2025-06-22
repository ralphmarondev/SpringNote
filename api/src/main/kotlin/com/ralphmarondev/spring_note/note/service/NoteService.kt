package com.ralphmarondev.spring_note.note.service

import com.ralphmarondev.spring_note.note.entity.Note
import com.ralphmarondev.spring_note.note.repository.NoteRepository
import com.ralphmarondev.spring_note.user.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NoteRepository,
    private val userRepository: UserRepository
) {

    fun createNote(note: Note): Note {
        val email = SecurityContextHolder.getContext().authentication.principal as String
        val user = userRepository.findByEmail(email) ?: throw Exception("User not found.")
        val newNote = note.copy(
            ownerId = user.id
        )
        return noteRepository.save(newNote)
    }

    fun getNotes(): List<Note> {
        val email = SecurityContextHolder.getContext().authentication.principal as String
        val user = userRepository.findByEmail(email) ?: throw Exception("User not found.")
        return noteRepository.findAllByOwnerIdAndIsDeletedFalseOrderByCreateDateDesc(user.id)
    }

    fun deleteNote(noteId: Long): Boolean {
        val email = SecurityContextHolder.getContext().authentication.principal as String
        val user = userRepository.findByEmail(email) ?: throw Exception("User not found.")
        val note = noteRepository.findById(noteId).orElse(null) ?: return false

        if (note.ownerId == user.id) {
            val updateNote = note.copy(isDeleted = true)
            noteRepository.save(updateNote)
            return true
        }
        return false
    }
}