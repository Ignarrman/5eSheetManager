package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsKnownProgressionEntity

@Dao
interface EldritchInvocationsKnownProgressionDao {

    @Query(
        "SELECT * FROM eldritch_invocations_known_progression ORDER BY level"
    )
    suspend fun getProgression(): List<EldritchInvocationsKnownProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<EldritchInvocationsKnownProgressionEntity>)

    @Query("DELETE FROM eldritch_invocations_known_progression")
    suspend fun deleteAll()
}