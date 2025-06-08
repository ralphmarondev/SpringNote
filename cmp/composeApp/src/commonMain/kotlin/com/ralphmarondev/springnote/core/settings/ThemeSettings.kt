package com.ralphmarondev.springnote.core.settings

import kotlinx.coroutines.flow.StateFlow

interface ThemeSettings {
    fun toggleDarkMode()
    val darkModeFlow: StateFlow<Boolean>
}