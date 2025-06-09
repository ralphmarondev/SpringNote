package com.ralphmarondev.springnote.note.presentation.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.usecase.GetAllNotesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteListViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        startPolling()
    }

    private fun startPolling() {
        viewModelScope.launch {
            while (true) {
                try {
                    _notes.value = getAllNotesUseCase()
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
                delay(60_000L) // 1 minute
            }
        }
    }

    fun refresh(onDone: () -> Unit) {
        viewModelScope.launch {
            try {
                _notes.value = getAllNotesUseCase()
            } catch (e: Exception) {
                println("Refresh error: ${e.message}")
            } finally {
                onDone()
            }
        }
    }
}