package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase

suspend fun clearClassesReferenceData(database: AppDatabase){
    database.bardicInspirationProgressionDao().deleteAll()

    database.barbarianProgressionDao().deleteAll()

    database.classDao().deleteAllFeatures()
    database.classDao().deleteAll()
}

suspend fun insertClassesReferenceData(database: AppDatabase) {
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