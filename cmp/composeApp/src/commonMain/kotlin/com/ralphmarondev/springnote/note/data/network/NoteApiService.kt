package com.ralphmarondev.springnote.note.data.network

import com.ralphmarondev.springnote.note.data.model.Note
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val BASE_URL = "http://localhost:8085"

class NoteApiService(
    private val httpClient: HttpClient
) {
    suspend fun getAllNotes(): List<Note> {
        return httpClient.get("$BASE_URL/notes").body()
    }
}