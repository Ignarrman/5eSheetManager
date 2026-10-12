package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CharacterSpellDao {

    @Query("""
        SELECT spellName
        FROM character_spells
        WHERE characterId = :characterId
        ORDER BY spellName
    """)
    suspend fun getSpellNames(
        characterId: Long
    ): List<String>

    @Query("""
        DELETE FROM character_spells
        WHERE characterId = :characterId
    """)
    suspend fun deleteByCharacterId(
        characterId: Long
    )
}