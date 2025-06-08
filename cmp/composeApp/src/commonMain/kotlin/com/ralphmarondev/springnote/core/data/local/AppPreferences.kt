package com.ralphmarondev.springnote.core.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import okio.Path.Companion.toPath

val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")
val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")

fun createDataStore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}

internal const val DATA_STORE_FILE_NAME = "spring_note_prefs.preferences_pb"