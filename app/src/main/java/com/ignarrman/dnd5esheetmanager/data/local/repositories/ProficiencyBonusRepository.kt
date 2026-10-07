package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.ProficiencyBonusProgressionDao
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.ProficiencyBonusProgression

class ProficiencyBonusProgressionRepository(
    private val dao: ProficiencyBonusProgressionDao
) {

    suspend fun getAll(): List<ProficiencyBonusProgression> {
        return dao
            .getAll()
            .map { it.toDomain() }
    }

    suspend fun getByLevel(
        level: Int
    ): ProficiencyBonusProgression? {
        return dao
            .getByLevel(level)
            ?.toDomain()
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}