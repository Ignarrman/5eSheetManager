package com.ignarrman.dnd5esheetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ignarrman.dnd5esheetmanager.ui.navigation.AppNavigation
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            _5eSheetManagerTheme {
                AppNavigation()
            }
        }
    }
}