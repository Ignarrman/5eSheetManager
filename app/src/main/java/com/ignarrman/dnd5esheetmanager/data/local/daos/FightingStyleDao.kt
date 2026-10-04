package com.ignarrman.dnd5esheetmanager.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity

@Dao
interface FightingStyleDao {

    @Query(" SELECT * FROM fighting_styles WHERE id IN (:ids)")
    suspend fun getFightingStylesByIds(ids: List<Long>): List<FightingStyleEntity>

    @Insert
    suspend fun insertAll(fightingStyles: List<FightingStyleEntity>)

    @Query("DELETE FROM fighting_styles")
    suspend fun deleteAll()
}