package com.ralphmarondev.springnote.note.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: String,
    val title: String,
    val content: String,
    val color: Int,
    val createdAt: String
)
