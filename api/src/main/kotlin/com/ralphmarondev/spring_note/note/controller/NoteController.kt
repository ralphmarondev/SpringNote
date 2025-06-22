package com.ralphmarondev.spring_note.note.controller

import com.ralphmarondev.spring_note.note.entity.Note
import com.ralphmarondev.spring_note.note.service.NoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(
    private val service: NoteService
) {

    @PostMapping("/create")
    fun saveNote(@RequestBody note: Note): ResponseEntity<Note> {
        val savedNote = service.createNote(note)
        return ResponseEntity.ok(savedNote)
    }

    @GetMapping
    fun getAllNotes(): List<Note> {
        return service.getNotes()
    }

    @PostMapping("/delete/{noteId}")
    fun deleteNote(
        @PathVariable noteId: Long
    ): Boolean {
        return service.deleteNote(noteId = noteId)
    }
}