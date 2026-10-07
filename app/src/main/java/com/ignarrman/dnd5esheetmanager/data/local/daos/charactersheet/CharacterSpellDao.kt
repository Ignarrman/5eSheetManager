package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSpellCrossRef

@Dao
interface CharacterSpellDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(relation: CharacterSpellCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(
        relations: List<CharacterSpellCrossRef>
    )

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