package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SorceryPointProgressionEntity

@Dao
interface SorceryPointProgressionDao {

    @Query("SELECT * FROM sorcery_points_progression ORDER BY level")
    suspend fun getProgression(): List<SorceryPointProgressionEntity>

    @Insert
    suspend fun insertAll(
        progression: List<SorceryPointProgressionEntity>
    )

    @Query("DELETE FROM sorcery_points_progression")
    suspend fun deleteAll()
}