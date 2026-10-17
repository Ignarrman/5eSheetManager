package com.ignarrman.dnd5esheetmanager.data.local.repositories

import androidx.room.Dao
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import javax.inject.Inject

@Dao
class FeatureRepository @Inject constructor(
    private val featureDao: FeatureDao
) {

    suspend fun getById(id: Long): Feature? {
        return featureDao.getById(id)?.toDomain()
    }

    suspend fun getByIds(ids: List<Long>): List<Feature> {
        if (ids.isEmpty()) return emptyList()

        return featureDao.getFeaturesByIds(ids)
            .map { it.toDomain() }
            .sortedBy { feature -> ids.indexOf(feature.id) }
    }

    suspend fun insertAll(features: List<FeatureEntity>) {
        featureDao.insertAll(features)
    }

    suspend fun deleteAll() {
        featureDao.deleteAll()
    }
}