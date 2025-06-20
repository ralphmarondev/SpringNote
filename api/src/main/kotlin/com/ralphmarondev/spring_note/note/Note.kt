package com.ralphmarondev.spring_note.note

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "notes")
data class Note(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val ownerId: Long,
    val title: String,
    val caption: String,
    @CreationTimestamp @Column(updatable = false)
    val createDate: LocalDateTime? = null,
    @Column(nullable = false)
    val isDeleted: Boolean = false
)