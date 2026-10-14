package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao.FeatDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import javax.inject.Inject

class FeatRepository @Inject constructor(
    private val featDao: FeatDao
) {

    suspend fun getAll(): List<Feat> {
        return featDao
            .getAll()
            .map { it.toDomain() }
    }

    suspend fun getById(
        id: Long
    ): Feat? {
        return featDao
            .getById(id)
            ?.toDomain()
    }

    suspend fun getByName(
        name: String
    ): List<Feat> {
        return featDao
            .getByName(name)
            .map { it.toDomain() }
    }

    suspend fun deleteAll() {
        featDao.deleteAll()
    }
}