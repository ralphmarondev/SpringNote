package com.ralphmarondev.springnote

import android.app.Application
import com.ralphmarondev.springnote.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApp)
        }
    }
}