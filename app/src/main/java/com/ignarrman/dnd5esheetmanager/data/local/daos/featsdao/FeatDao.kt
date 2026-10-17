package com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterFeatCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity

@Dao
interface FeatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(feats: List<FeatEntity>)

    @Query("SELECT * FROM feats ORDER BY name")
    suspend fun getAll(): List<FeatEntity>

    @Query("SELECT * FROM feats WHERE id = :id")
    suspend fun getById(id: Long): FeatEntity?

    @Query("""
    SELECT * FROM feats
    WHERE id IN (:ids)
""")
    suspend fun getByIds(
        ids: List<Long>
    ): List<FeatEntity>

    @Query("""
    SELECT * FROM character_feats
    WHERE characterId = :characterId
""")
    suspend fun getByCharacterId(
        characterId: Long
    ): List<CharacterFeatCrossRef>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacterRef(
        refs: List<CharacterFeatCrossRef>
    )

    @Query("""
    DELETE FROM character_feats
    WHERE characterId = :characterId
""")
    suspend fun deleteByCharacterId(
        characterId: Long
    )

    @Query("DELETE FROM feats")
    suspend fun deleteAll()
}