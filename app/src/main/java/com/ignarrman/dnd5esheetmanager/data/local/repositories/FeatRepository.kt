package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao.FeatDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.data.mappers.toEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
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

    suspend fun insert(
        feat: Feat,
        characterId: Long
    ): Long {
        return featDao.insertCharacterFeat(
            characterFeat = CharacterFeatCrossRef(characterId, feat.id!!)
        )
    }

    suspend fun deleteFeat(
        characterId: Long,
        featId: Long
    ) {
        featDao.deleteByCharacterIdAndFeatId(characterId, featId)
    }

    suspend fun deleteAll() {
        featDao.deleteAll()
    }
}