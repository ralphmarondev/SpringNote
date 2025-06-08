package com.ralphmarondev.springnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.springnote.core.settings.ThemeSettings
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val themeSettings: ThemeSettings = get()
            App(themeSettings = themeSettings)
        }
    }
}