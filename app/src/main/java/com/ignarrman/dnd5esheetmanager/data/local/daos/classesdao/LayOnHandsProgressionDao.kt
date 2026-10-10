package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.LayOnHandsProgressionEntity

@Dao
interface LayOnHandsProgressionDao {

    @Query("SELECT * FROM lay_on_hands_progression ORDER BY level")
    suspend fun getProgression(): List<LayOnHandsProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<LayOnHandsProgressionEntity>)

    @Query("DELETE FROM lay_on_hands_progression")
    suspend fun deleteAll()
}