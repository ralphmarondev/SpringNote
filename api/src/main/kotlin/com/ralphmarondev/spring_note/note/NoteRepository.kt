package com.ralphmarondev.spring_note.note

import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {
    fun findAllByOwnerIdAndIsDeletedFalseOrderByCreateDateDesc(ownerId: Long): List<Note>
}