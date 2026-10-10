package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionProgressionEntity

@Dao
interface InfusionProgressionDao {

    @Query("SELECT * FROM infusion_progression ORDER BY level")
    suspend fun getProgression(): List<InfusionProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<InfusionProgressionEntity>)

    @Query("DELETE FROM infusion_progression")
    suspend fun deleteAll()
}