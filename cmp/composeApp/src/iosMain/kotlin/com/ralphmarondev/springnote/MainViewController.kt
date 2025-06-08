package com.ralphmarondev.springnote

import androidx.compose.ui.window.ComposeUIViewController
import com.ralphmarondev.springnote.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}