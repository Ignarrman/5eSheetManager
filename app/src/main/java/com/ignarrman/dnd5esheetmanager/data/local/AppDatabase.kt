package com.ignarrman.dnd5esheetmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesDao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesDao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef

@Database(
    entities = [
        ClassEntity::class,
        FeatureEntity::class,
        ClassFeatureCrossRef::class,
        BarbarianProgressionEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun classDao(): ClassDao
    abstract fun featureDao(): FeatureDao
    abstract fun barbarianProgressionDao(): BarbarianProgressionDao
}