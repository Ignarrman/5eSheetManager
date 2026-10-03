package com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

@Dao
interface SpellcastingDao {

    @Query("SELECT * FROM spellcasting WHERE classId = :classId")
    suspend fun getSpellcasting(classId: Long): SpellcastingEntity?

    @Query("SELECT * FROM cantrip_progression WHERE classId = :classId ORDER BY level")
    suspend fun getCantripProgression(classId: Long): List<CantripProgressionEntity>

    @Query("SELECT * FROM spell_slot_progression WHERE classId = :classId ORDER BY level, slotLevel")
    suspend fun getSpellSlotProgression(classId: Long): List<SpellSlotProgressionEntity>

    @Query("SELECT * FROM spells_known_progression WHERE classId = :classId ORDER BY level")
    suspend fun getSpellsKnownProgression(classId: Long): List<SpellsKnownProgressionEntity>

    @Insert
    suspend fun insertSpellcasting(
        spellcasting: SpellcastingEntity
    )

    @Insert
    suspend fun insertCantrips(
        cantrips: List<CantripProgressionEntity>
    )

    @Insert
    suspend fun insertSpellsKnown(
        spellsKnown: List<SpellsKnownProgressionEntity>
    )

    @Insert
    suspend fun insertSpellSlots(
        spellSlots: List<SpellSlotProgressionEntity>
    )
}