package com.ralphmarondev.springnote.note.data.network

import com.ralphmarondev.springnote.core.util.BASE_URL
import com.ralphmarondev.springnote.note.data.model.Note
import com.ralphmarondev.springnote.note.data.model.NoteRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class NoteApiService(
    private val httpClient: HttpClient
) {
    suspend fun getAllNotes(): List<Note> {
        return httpClient.get("$BASE_URL/notes").body()
    }

    suspend fun getNoteById(id: String): Note {
        return httpClient.get("$BASE_URL/notes/$id").body()
    }

    suspend fun saveNote(noteRequest: NoteRequest): Note {
        return httpClient.post("$BASE_URL/notes") {
            contentType(ContentType.Application.Json)
            setBody(noteRequest)
        }.body()
    }

    suspend fun deleteNoteById(id: String) {
        httpClient.delete("$BASE_URL/notes/$id")
    }
}