package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef

@Dao
interface CharacterFeatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(relation: CharacterFeatCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(
        relations: List<CharacterFeatCrossRef>
    )

    @Query("""
        SELECT featId
        FROM character_feats
        WHERE characterId = :characterId
        ORDER BY featId
    """)
    suspend fun getFeatIds(
        characterId: Long
    ): List<Long>

    @Query("""
        DELETE FROM character_feats
        WHERE characterId = :characterId
    """)
    suspend fun deleteByCharacterId(
        characterId: Long
    )
}
