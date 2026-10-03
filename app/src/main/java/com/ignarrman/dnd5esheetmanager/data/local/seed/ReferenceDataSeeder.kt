package com.ignarrman.dnd5esheetmanager.data.local.seed

import androidx.room.withTransaction
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BarbarianReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BardReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.ClassReferenceData
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

        database.bardicInspirationProgressionDao().deleteAll()

        database.barbarianProgressionDao().deleteAll()

        database.classDao().deleteAllFeatures()
        database.featureDao().deleteAll()

        database.classDao().deleteAll()
    }

    private suspend fun insertReferenceData() {

        database.classDao().insertAll(
            ClassReferenceData.classes
        )

        database.featureDao().insertAll(
            BarbarianReferenceData.features +
                    BardReferenceData.features
        )

        database.classDao().insertFeatures(
            BarbarianReferenceData.featureRelations +
                    BardReferenceData.featureRelations
        )

        database.barbarianProgressionDao().insertAll(
            BarbarianReferenceData.progression
        )

        database.bardicInspirationProgressionDao().insertAll(
            BardReferenceData.bardicInspiration
        )

        database.spellcastingDao().insertSpellcasting(
            BardReferenceData.spellcasting
        )

        database.spellcastingDao().insertCantrips(
            BardReferenceData.cantrips
        )

        database.spellcastingDao().insertSpellsKnown(
            BardReferenceData.spellsKnown
        )

        database.spellcastingDao().insertSpellSlots(
            BardReferenceData.spellSlots
        )
    }
}