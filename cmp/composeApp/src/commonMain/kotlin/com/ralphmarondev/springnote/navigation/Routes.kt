package com.ralphmarondev.springnote.navigation

import kotlinx.serialization.Serializable

@Serializable
object Routes {

    @Serializable
    data object Login

    @Serializable
    data object Home
}