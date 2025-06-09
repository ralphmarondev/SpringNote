package com.ralphmarondev.springnote.note.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NoteRequest(
    val title: String,
    val content: String,
    val color: Int
)