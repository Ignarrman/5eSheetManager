package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ProficiencyBonusProgressionEntity

@Dao
interface ProficiencyBonusProgressionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(
        progression: List<ProficiencyBonusProgressionEntity>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        progression: ProficiencyBonusProgressionEntity
    )

    @Query("""
        SELECT * 
        FROM proficiency_bonus_progression
        ORDER BY level
    """)
    suspend fun getAll(): List<ProficiencyBonusProgressionEntity>

    @Query("""
        SELECT *
        FROM proficiency_bonus_progression
        WHERE level = :level
    """)
    suspend fun getByLevel(
        level: Int
    ): ProficiencyBonusProgressionEntity?

    @Query("DELETE FROM proficiency_bonus_progression")
    suspend fun deleteAll()
}