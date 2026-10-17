package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds.BackgroundDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundWithFeature
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import javax.inject.Inject

class BackgroundRepository @Inject constructor(
    private val backgroundDao: BackgroundDao,
    private val featureDao: FeatureDao
) {

    suspend fun getAll(): List<Background> {
        val backgroundsWithFeatures =
            backgroundDao.getAll().mapNotNull { background ->

                featureDao.getById(background.featureId)?.let { feature ->
                    BackgroundWithFeature(
                        background = background,
                        feature = feature
                    )
                }
            }

        return backgroundsWithFeatures.map(BackgroundWithFeature::toDomain)
    }

    suspend fun getByName(name: String): Background? {

        val background = backgroundDao.getByName(name) ?: return null
        val feature = featureDao.getById(background.featureId) ?: return null

        return BackgroundWithFeature(
            background = background,
            feature = feature
        ).toDomain()
    }

    suspend fun getById(id: Long): Background? {
        val background = backgroundDao.getById(id = id) ?: return null
        val feature = featureDao.getById(background.featureId) ?: return null

        return  BackgroundWithFeature(
            background = background,
            feature = feature
        ).toDomain()
    }
}