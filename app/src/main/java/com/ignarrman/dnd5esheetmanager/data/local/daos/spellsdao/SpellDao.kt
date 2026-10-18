package com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSpellCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpellDao {

    @Query("SELECT * FROM spells")
    suspend fun getAll(): List<SpellEntity>

    @Query("SELECT * FROM spells WHERE id = :id")
    suspend fun getById(id: Long): SpellEntity?

    @Query("""
    SELECT * FROM spells
    WHERE id IN (:ids)
""")
    suspend fun getByIds(
        ids: List<Long>
    ): List<SpellEntity>

    @Query("""
        SELECT * FROM character_spells
        WHERE characterId = :characterId
    """)
    suspend fun getByCharacterId(
        characterId: Long
    ): List<CharacterSpellCrossRef>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacterRef(
        refs: List<CharacterSpellCrossRef>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterSpell(
        characterSpell: CharacterSpellCrossRef
    ): Long

    @Query("""
    DELETE FROM character_spells
    WHERE characterId = :characterId
""")
    suspend fun deleteByCharacterId(
        characterId: Long
    )

    @Query("""
    DELETE FROM character_spells
    WHERE characterId = :characterId AND spellId = :spellId
""")
    suspend fun deleteByCharacterIdAndSpellId(
        characterId: Long,
        spellId: Long
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(spells: List<SpellEntity>)

    @Query("DELETE FROM spells")
    suspend fun deleteAll()
}