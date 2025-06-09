package com.ralphmarondev.springnote.core.di

import com.ralphmarondev.springnote.core.data.network.HttpClientFactory
import com.ralphmarondev.springnote.core.settings.ThemeSettings
import com.ralphmarondev.springnote.core.settings.ThemeSettingsImpl
import org.koin.dsl.module

val coreModule = module {
    single<ThemeSettings> { ThemeSettingsImpl(get()) }

    single { HttpClientFactory.create(get(), get()) }
}