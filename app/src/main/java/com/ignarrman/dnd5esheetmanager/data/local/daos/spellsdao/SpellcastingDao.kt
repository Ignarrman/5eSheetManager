package com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity

@Dao
interface SpellcastingDao {

    @Query("SELECT * FROM spellcasting WHERE classId = :classId")
    suspend fun getSpellcasting(classId: Long): SpellcastingEntity?


    @Query("SELECT * FROM spell_slot_progression WHERE classId = :classId ORDER BY level, slotLevel")
    suspend fun getSpellSlotProgression(classId: Long): List<SpellSlotProgressionEntity>

    @Insert
    suspend fun insertSpellcasting(
        spellcasting: SpellcastingEntity
    )

    @Insert
    suspend fun insertSpellSlots(
        spellSlots: List<SpellSlotProgressionEntity>
    )

    @Query("DELETE FROM spell_slot_progression")
    suspend fun deleteAllSpellSlots()

    @Query("DELETE FROM spellcasting")
    suspend fun deleteAllSpellcasting()
}