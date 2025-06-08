package com.ralphmarondev.springnote

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform