package com.ignarrman.dnd5esheetmanager.data.local.seed

import androidx.room.withTransaction
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BarbarianReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BardReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.ClassReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.clearClassesReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.insertClassesReferenceData
import javax.inject.Inject
import javax.inject.Singleton

private const val REFERENCE_DATA_KEY = "reference_data"
private const val REFERENCE_DATA_VERSION = 1

@Singleton
class ReferenceDataSeeder @Inject constructor(
    private val database: AppDatabase
) {

    suspend fun seed() {

        database.withTransaction {

            val currentVersion =
                database.referenceDataMetadataDao()
                    .getVersion(REFERENCE_DATA_KEY)

            if (currentVersion == REFERENCE_DATA_VERSION) {
                return@withTransaction
            }

            clearReferenceData()

            insertReferenceData()

            database.referenceDataMetadataDao().setVersion(
                ReferenceDataMetadataEntity(
                    key = REFERENCE_DATA_KEY,
                    version = REFERENCE_DATA_VERSION
                )
            )
        }
    }

    private suspend fun clearReferenceData() {

        database.spellcastingDao().deleteAllSpellSlots()
        database.spellcastingDao().deleteAllSpellsKnown()
        database.spellcastingDao().deleteAllCantrips()
        database.spellcastingDao().deleteAllSpellcasting()

        clearClassesReferenceData(database = database)

        database.featureDao().deleteAll()


    }

    private suspend fun insertReferenceData() {

        insertClassesReferenceData(database = database)

    }
}