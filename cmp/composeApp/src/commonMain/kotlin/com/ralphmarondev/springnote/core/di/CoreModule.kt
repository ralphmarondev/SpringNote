package com.ralphmarondev.springnote.core.di

import com.ralphmarondev.springnote.core.settings.ThemeSettings
import com.ralphmarondev.springnote.core.settings.ThemeSettingsImpl
import org.koin.dsl.module

val coreModule = module {
    single<ThemeSettings> { ThemeSettingsImpl(get()) }
}