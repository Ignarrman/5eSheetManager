package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsEntity

@Dao
interface EldritchInvocationsProgressionDao {

    @Query("SELECT * FROM eldritch_invocations_progression ORDER BY level")
    suspend fun getProgression(): List<EldritchInvocationsEntity>

    @Insert
    suspend fun insertAll(
        progression: List<EldritchInvocationsEntity>
    )

    @Query("DELETE FROM eldritch_invocations_progression")
    suspend fun deleteAll()
}