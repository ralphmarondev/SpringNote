package com.ralphmarondev.springnote.auth.domain.model

data class TokenPair(
    val access: String,
    val refresh: String
)