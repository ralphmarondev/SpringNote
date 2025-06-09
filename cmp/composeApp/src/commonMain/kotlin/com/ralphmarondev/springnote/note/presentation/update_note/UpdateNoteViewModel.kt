package com.ralphmarondev.springnote.note.presentation.update_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.springnote.core.domain.model.Result
import com.ralphmarondev.springnote.note.domain.model.Note
import com.ralphmarondev.springnote.note.domain.usecase.GetNoteByIdUseCase
import com.ralphmarondev.springnote.note.domain.usecase.UpdateNoteUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UpdateNoteViewModel(
    private val noteId: String,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    private val _content = MutableStateFlow("")
    val content = _content.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()

    private val _showSnackbar = MutableStateFlow(false)
    val showSnackbar = _showSnackbar.asStateFlow()

    private val _isSaving = MutableStateFlow(false)
    private val _note = MutableStateFlow<Note?>(null)


    init {
        viewModelScope.launch {
            val note: Note = getNoteByIdUseCase(noteId)
            _note.value = note
            _title.value = note.title
            _content.value = note.content
        }
    }

    fun onTitleValueChange(value: String) {
        _title.value = value
    }

    fun onContentValueChange(value: String) {
        _content.value = value
    }

    fun setShowSnackbar(value: Boolean) {
        _showSnackbar.value = value
    }

    fun update() {
        viewModelScope.launch {
            if (_isSaving.value) {
                return@launch
            }
            _isSaving.value = true

            val updatedNote = Note(
                id = _note.value?.id ?: "",
                title = _title.value.trim(),
                content = _content.value.trim(),
                color = _note.value?.color ?: 1,
                createdAt = _note.value?.createdAt ?: ""
            )
            val result = updateNoteUseCase(updatedNote)
            _response.value = result

            if (_response.value?.success == true) {
                _title.value = ""
                _content.value = ""
            }
            _isSaving.value = false
        }
    }

    fun resetResponse() {
        viewModelScope.launch {
            delay(3000)
            _response.value = null
        }
    }
}