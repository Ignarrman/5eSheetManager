package com.ignarrman.dnd5esheetmanager.data.local.seed

import androidx.room.withTransaction
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BarbarianReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.BardReferenceData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.ClassReferenceData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReferenceDataSeeder @Inject constructor(
    private val database: AppDatabase
) {

    suspend fun seed() {
        database.withTransaction {

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
}