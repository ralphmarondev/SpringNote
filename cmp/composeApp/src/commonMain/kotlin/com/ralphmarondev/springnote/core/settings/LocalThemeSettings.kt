package com.ralphmarondev.springnote.core.settings

import androidx.compose.runtime.staticCompositionLocalOf

val LocalThemeSettings = staticCompositionLocalOf<ThemeSettings> {
    error("ThemeSettings not provided")
}