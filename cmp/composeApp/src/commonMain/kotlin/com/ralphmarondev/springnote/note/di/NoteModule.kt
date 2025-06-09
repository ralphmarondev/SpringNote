package com.ralphmarondev.springnote.note.di

import com.ralphmarondev.springnote.note.data.network.NoteApiService
import com.ralphmarondev.springnote.note.data.repository.NoteRepositoryImpl
import com.ralphmarondev.springnote.note.domain.repository.NoteRepository
import com.ralphmarondev.springnote.note.domain.usecase.GetAllNotesUseCase
import com.ralphmarondev.springnote.note.domain.usecase.SaveNoteUseCase
import com.ralphmarondev.springnote.note.presentation.new_note.NewNoteViewModel
import com.ralphmarondev.springnote.note.presentation.note_list.NoteListViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val noteModule = module {
    singleOf(::NoteApiService)
    singleOf(::NoteRepositoryImpl).bind<NoteRepository>()

    factoryOf(::GetAllNotesUseCase)
    factoryOf(::SaveNoteUseCase)

    factoryOf(::NoteListViewModel)
    factoryOf(::NewNoteViewModel)
}