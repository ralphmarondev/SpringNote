package com.ralphmarondev.springnote

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import com.ralphmarondev.springnote.core.settings.LocalThemeSettings
import com.ralphmarondev.springnote.core.settings.ThemeSettings
import com.ralphmarondev.springnote.core.theme.SpringNoteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    themeSettings: ThemeSettings
) {
    CompositionLocalProvider(
        LocalThemeSettings provides themeSettings
    ) {
        SpringNoteTheme(
            darkTheme = themeSettings.darkModeFlow.collectAsState().value
        ) {
            HomeScreen()
        }
    }
}