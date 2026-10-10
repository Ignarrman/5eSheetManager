package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkProgressionEntity

@Dao
interface MonkProgressionDao {

    @Query("SELECT * FROM monk_progression ORDER BY level")
    suspend fun getProgression(): List<MonkProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<MonkProgressionEntity>)

    @Query("DELETE FROM monk_progression")
    suspend fun deleteAll()
}