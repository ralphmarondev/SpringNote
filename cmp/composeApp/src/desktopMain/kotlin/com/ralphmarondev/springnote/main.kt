package com.ralphmarondev.springnote

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ralphmarondev.springnote.core.settings.ThemeSettings
import com.ralphmarondev.springnote.di.initKoin
import org.koin.core.context.GlobalContext.get

fun main() {
    initKoin()
    val themeSettings = get().get<ThemeSettings>()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "SpringNote",
        ) {
            App(themeSettings = themeSettings)
        }
    }
}