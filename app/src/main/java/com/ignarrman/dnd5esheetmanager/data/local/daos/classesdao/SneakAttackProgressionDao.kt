package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SneakAttackProgressionEntity

@Dao
interface SneakAttackProgressionDao {

    @Query("SELECT * FROM sneak_attack_progression ORDER BY level")
    suspend fun getProgression(): List<SneakAttackProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<SneakAttackProgressionEntity>)

    @Query("DELETE FROM sneak_attack_progression")
    suspend fun deleteAll()
}