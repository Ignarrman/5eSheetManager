package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ChannelDivinityProgressionEntity

@Dao
interface ChannelDivinityProgressionDao {

    @Query("SELECT * FROM channel_divinity_progression ORDER BY level")
    suspend fun getProgression(): List<ChannelDivinityProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<ChannelDivinityProgressionEntity>)

    @Query("DELETE FROM channel_divinity_progression")
    suspend fun deleteAll()
}