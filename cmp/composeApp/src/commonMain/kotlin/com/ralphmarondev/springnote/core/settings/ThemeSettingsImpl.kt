package com.ralphmarondev.springnote.core.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.ralphmarondev.springnote.core.data.local.DARK_THEME_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ThemeSettingsImpl(
    private val dataStore: DataStore<Preferences>
) : ThemeSettings {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _darkModeFlow = MutableStateFlow(false)
    override val darkModeFlow: StateFlow<Boolean> = _darkModeFlow

    init {
        scope.launch {
            dataStore.data.map { it[DARK_THEME_KEY] ?: false }
                .collect { _darkModeFlow.value = it }
        }
    }


    override fun toggleDarkMode() {
        scope.launch {
            dataStore.edit {
                val current = it[DARK_THEME_KEY] ?: false
                it[DARK_THEME_KEY] = !current
            }
        }
    }
}