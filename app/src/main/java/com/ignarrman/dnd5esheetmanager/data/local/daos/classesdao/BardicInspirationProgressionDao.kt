package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity

@Dao
interface BardicInspirationProgressionDao {

    @Query("SELECT * FROM bardic_inspiration_progression ORDER BY level")
    suspend fun getProgression(): List<BardicInspirationProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<BardicInspirationProgressionEntity>)

    @Query("DELETE FROM bardic_inspiration_progression")
    suspend fun deleteAll()
}