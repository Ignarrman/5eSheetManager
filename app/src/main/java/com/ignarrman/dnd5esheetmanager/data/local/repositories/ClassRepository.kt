package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BardicInspirationProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardData
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Bard

class ClassRepository(
    private val classDao: ClassDao,
    private val featureDao: FeatureDao,
    private val barbarianProgressionDao: BarbarianProgressionDao,
    private val bardicInspirationProgressionDao: BardicInspirationProgressionDao,
    private val spellcastingDao: SpellcastingDao
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

    suspend fun getBard(id: Long): Bard {
        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val relations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                relations.map { it.featureId }
            )

        val bardicInspirationProgression =
            bardicInspirationProgressionDao.getProgression()

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        return BardData(
            classEntity = classEntity,
            featureRelations = relations,
            features = features,
            bardicInspirationProgression = bardicInspirationProgression,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression
        ).toDomain()
    }
}