package com.ralphmarondev.springnote.auth.di

import com.ralphmarondev.springnote.auth.data.network.AuthApiService
import com.ralphmarondev.springnote.auth.data.repository.AuthRepositoryImpl
import com.ralphmarondev.springnote.auth.domain.repository.AuthRepository
import com.ralphmarondev.springnote.auth.domain.usecase.LoginUseCase
import com.ralphmarondev.springnote.auth.domain.usecase.RegisterUseCase
import com.ralphmarondev.springnote.auth.presentation.login.LoginViewModel
import com.ralphmarondev.springnote.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authModule = module {
    singleOf(::AuthApiService)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()

    factoryOf(::LoginUseCase)
    factoryOf(::RegisterUseCase)

    factoryOf(::LoginViewModel)
    factoryOf(::RegisterViewModel)
}