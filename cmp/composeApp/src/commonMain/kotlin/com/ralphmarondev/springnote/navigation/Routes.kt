package com.ralphmarondev.springnote.navigation

import kotlinx.serialization.Serializable

@Serializable
object Routes {

    @Serializable
    data object Login

    @Serializable
    data object Register

    @Serializable
    data object NoteList

    @Serializable
    data object NewNote

    @Serializable
    data class NoteDetails(val id: String)

    @Serializable
    data class UpdateNote(val id: String)
}