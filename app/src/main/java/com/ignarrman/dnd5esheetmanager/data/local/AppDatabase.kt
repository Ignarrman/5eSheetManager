package com.ignarrman.dnd5esheetmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.ReferenceDataMetadataDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BardicInspirationProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

@Database(
    entities = [
        ClassEntity::class,
        FeatureEntity::class,
        ClassFeatureCrossRef::class,
        BarbarianProgressionEntity::class,
        BardicInspirationProgressionEntity::class,
        SpellcastingEntity::class,
        CantripProgressionEntity::class,
        SpellSlotProgressionEntity::class,
        SpellsKnownProgressionEntity::class,
        ReferenceDataMetadataEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun classDao(): ClassDao
    abstract fun featureDao(): FeatureDao
    abstract fun barbarianProgressionDao(): BarbarianProgressionDao
    abstract fun bardicInspirationProgressionDao(): BardicInspirationProgressionDao
    abstract fun spellcastingDao(): SpellcastingDao
    abstract fun referenceDataMetadataDao(): ReferenceDataMetadataDao
}