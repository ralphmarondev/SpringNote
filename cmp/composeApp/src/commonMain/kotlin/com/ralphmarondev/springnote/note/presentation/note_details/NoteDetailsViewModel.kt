package com.ralphmarondev.springnote.note.presentation.note_details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteDetailsViewModel(
    private val noteId: String
) : ViewModel() {

    private val _showConfirmDeleteDialog = MutableStateFlow(false)
    val showConfirmDeleteDialog = _showConfirmDeleteDialog.asStateFlow()


    fun setShowConfirmDeleteDialog(value: Boolean) {
        _showConfirmDeleteDialog.value = value
    }

    fun delete() {

    }
}