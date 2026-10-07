package com.ignarrman.dnd5esheetmanager.data.local.seed

import android.content.Context
import androidx.room.withTransaction
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity
import com.ignarrman.dnd5esheetmanager.data.local.seed.background.clearBackgroundReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.background.insertBackgroundReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.charactersheet.insertProficiencyBonusProgressionReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.clearClassesReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.insertClassesReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.feats.clearFeatReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.feats.insertFeatReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.races.clearRaceReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.races.insertRaceReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.spells.clearSpellsReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.spells.insertSpellsReferenceData
import javax.inject.Inject
import javax.inject.Singleton

private const val REFERENCE_DATA_KEY = "reference_data"
private const val REFERENCE_DATA_VERSION = 1

@Singleton
class ReferenceDataSeeder @Inject constructor(
    private val database: AppDatabase,
    private val context: Context
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
        clearSpellsReferenceData(database = database)
        clearBackgroundReferenceData(database = database)
        clearRaceReferenceData(database = database)
        clearFeatReferenceData(database = database)

        database.featureDao().deleteAll()


    }

    private suspend fun insertReferenceData() {

        insertProficiencyBonusProgressionReferenceData(database = database)

        insertClassesReferenceData(database = database, context = context)

        insertSpellsReferenceData(database = database, context = context)

        insertBackgroundReferenceData(database = database, context = context)

        insertRaceReferenceData(database = database, context = context)

        insertFeatReferenceData(database = database, context = context)
    }
}