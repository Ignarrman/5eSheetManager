package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.races.RaceDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race

class RaceRepository(
    private val raceDao: RaceDao
) {

    suspend fun getAll(): List<Race> {
        return raceDao
            .getAll()
            .map { raceEntity ->
                raceEntity.toDomain(
                    features = raceDao.getFeaturesForRace(raceEntity.id)
                )
            }
    }

    suspend fun getByName(
        name: String,
        source: String
    ): Race? {
        return raceDao.getByNameAndSource(
            name = name,
            source = source
        )?.let { raceEntity ->
            raceEntity.toDomain(
                features = raceDao.getFeaturesForRace(raceEntity.id)
            )
        }
    }
}