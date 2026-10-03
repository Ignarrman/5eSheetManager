package com.ignarrman.dnd5esheetmanager.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity

@Dao
interface ReferenceDataMetadataDao {

    @Query(" SELECT version FROM reference_data_metadata WHERE `key` = :key")
    suspend fun getVersion(key: String): Int?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setVersion(metadata: ReferenceDataMetadataEntity)
}