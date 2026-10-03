package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesDao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesDao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian

class ClassRepository(
    private val classDao: ClassDao,
    private val featureDao: FeatureDao,
    private val barbarianProgressionDao: BarbarianProgressionDao
) {

    suspend fun getBarbarian(id: Long): Barbarian {

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val relations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                relations.map { it.featureId }
            )

        val progression =
            barbarianProgressionDao.getProgression()

        return BarbarianData(
            classEntity = classEntity,
            featureRelations = relations,
            features = features,
            progression = progression
        ).toDomain()
    }
}