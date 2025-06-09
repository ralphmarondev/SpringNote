package com.ralphmarondev.springnote.note.presentation.note_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.usecase.GetNoteByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteDetailsViewModel(
    private val noteId: String,
    private val getNoteByIdUseCase: GetNoteByIdUseCase
) : ViewModel() {

    private val _note = MutableStateFlow<Note?>(null)
    val note = _note.asStateFlow()

    private val _showConfirmDeleteDialog = MutableStateFlow(false)
    val showConfirmDeleteDialog = _showConfirmDeleteDialog.asStateFlow()


    init {
        viewModelScope.launch {
            _note.value = getNoteByIdUseCase(noteId)
        }
    }

    fun setShowConfirmDeleteDialog(value: Boolean) {
        _showConfirmDeleteDialog.value = value
    }

    fun delete() {

    }
}