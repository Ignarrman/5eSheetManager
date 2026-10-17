package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.races.RaceDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceWithFeatures
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import javax.inject.Inject

class RaceRepository @Inject constructor(
    private val raceDao: RaceDao
) {

    suspend fun getAll(): List<Race> {

        val raceWithFeatures = raceDao.getAll().map {
            RaceWithFeatures(
                raceEntity = it,
                features = raceDao.getFeaturesForRace(it.id)
            )
        }

        return raceWithFeatures.map { it.toDomain() }
    }

    suspend fun getByName(name: String, source: String): Race? {

        val raceEntity = raceDao.getByNameAndSource(name = name, source = source) ?: return null

        val raceWithFeatures =
            RaceWithFeatures(
                raceEntity = raceEntity,
                features = raceDao.getFeaturesForRace(raceEntity.id)
            )

        return raceWithFeatures.toDomain()
    }
}