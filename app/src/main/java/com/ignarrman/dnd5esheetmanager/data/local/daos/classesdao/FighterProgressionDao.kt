package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterProgressionEntity

@Dao
interface FighterProgressionDao {

    @Query("SELECT * FROM fighter_progression ORDER BY level")
    suspend fun getProgression(): List<FighterProgressionEntity>

    @Insert
    suspend fun insertAll(
        progression: List<FighterProgressionEntity>
    )

    @Query("DELETE FROM fighter_progression")
    suspend fun deleteAll()
}