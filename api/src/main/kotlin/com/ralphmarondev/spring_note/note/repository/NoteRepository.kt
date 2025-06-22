package com.ralphmarondev.spring_note.note.repository

import com.ralphmarondev.spring_note.note.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {
    fun findAllByOwnerIdAndIsDeletedFalseOrderByCreateDateDesc(ownerId: Long): List<Note>
}