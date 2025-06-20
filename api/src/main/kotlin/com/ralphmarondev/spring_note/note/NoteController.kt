package com.ralphmarondev.spring_note.note

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

    // GET /notes?ownerId=1
    @GetMapping
    fun getAllNotes(@RequestParam ownerId: Long): List<Note> {
        return service.getNotes(ownerId = ownerId)
    }

    // POST /notes/delete/123?ownerId=1
    @PostMapping("/delete/{noteId}")
    fun deleteNote(
        @PathVariable noteId: Long,
        @RequestParam ownerId: Long
    ): Boolean {
        return service.deleteNote(noteId = noteId, ownerId = ownerId)
    }
}