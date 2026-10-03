package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity

@Dao
interface BarbarianProgressionDao {

    @Query(" SELECT * FROM barbarian_progression ORDER BY level ")
    suspend fun getProgression(): List<BarbarianProgressionEntity>
}