package com.ralphmarondev.springnote.note.presentation.new_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.springnote.core.domain.model.Result
import com.ralphmarondev.springnote.note.domain.usecase.SaveNoteUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewNoteViewModel(
    private val saveNoteUseCase: SaveNoteUseCase
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    private val _content = MutableStateFlow("")
    val content = _content.asStateFlow()

    private val _response = MutableStateFlow<Result?>(null)
    val response = _response.asStateFlow()

    private val _showSnackbar = MutableStateFlow(false)
    val showSnackbar = _showSnackbar.asStateFlow()


    fun onTitleValueChange(value: String) {
        _title.value = value
    }

    fun onContentValueChange(value: String) {
        _content.value = value
    }

    fun setShowSnackbar(value: Boolean) {
        _showSnackbar.value = value
    }

    fun save() {
        viewModelScope.launch {
            val result = saveNoteUseCase(
                title = _title.value.trim(),
                content = _content.value.trim()
            )
            _response.value = result
        }
    }

    fun resetResponse() {
        viewModelScope.launch {
            delay(3000)
            _response.value = null
        }
    }
}