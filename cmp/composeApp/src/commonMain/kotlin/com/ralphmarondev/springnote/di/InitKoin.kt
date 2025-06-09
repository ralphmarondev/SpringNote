package com.ralphmarondev.springnote.di

import com.ralphmarondev.springnote.auth.di.authModule
import com.ralphmarondev.springnote.core.di.coreModule
import com.ralphmarondev.springnote.note.di.noteModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            coreModule,
            authModule,
            noteModule
        )
    }
}