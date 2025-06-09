package com.ralphmarondev.springnote.note.domain.model

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val color: Int,
    val createdAt: String
)
