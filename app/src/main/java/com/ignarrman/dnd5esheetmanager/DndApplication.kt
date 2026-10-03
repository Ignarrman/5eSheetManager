package com.ignarrman.dnd5esheetmanager

import android.app.Application
import com.ignarrman.dnd5esheetmanager.data.local.seed.ReferenceDataSeeder
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class DndApplication : Application() {

    @Inject
    lateinit var referenceDataSeeder: ReferenceDataSeeder

    private val applicationScope =
        CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()

        applicationScope.launch {
            referenceDataSeeder.seed()
        }
    }
}