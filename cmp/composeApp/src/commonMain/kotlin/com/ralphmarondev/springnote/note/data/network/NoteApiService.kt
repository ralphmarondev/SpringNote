package com.ralphmarondev.springnote.note.data.network

import com.ralphmarondev.springnote.note.data.model.Note
import com.ralphmarondev.springnote.note.data.model.NoteRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

private const val BASE_URL = "http://192.168.68.114:8085"

class NoteApiService(
    private val httpClient: HttpClient
) {
    suspend fun getAllNotes(): List<Note> {
        return httpClient.get("$BASE_URL/notes").body()
    }

    suspend fun saveNote(noteRequest: NoteRequest): Note {
        return httpClient.post("$BASE_URL/notes") {
            contentType(ContentType.Application.Json)
            setBody(noteRequest)
        }.body()
    }
}