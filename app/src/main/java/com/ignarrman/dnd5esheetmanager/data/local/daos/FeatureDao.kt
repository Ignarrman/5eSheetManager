package com.ignarrman.dnd5esheetmanager.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

@Dao
interface FeatureDao {

    @Query(" SELECT * FROM features WHERE id IN (:ids)")
    suspend fun getFeaturesByIds(ids: List<Long>): List<FeatureEntity>

    @Insert
    suspend fun insertAll(features: List<FeatureEntity>)

    @Query("DELETE FROM features")
    suspend fun deleteAll()
}