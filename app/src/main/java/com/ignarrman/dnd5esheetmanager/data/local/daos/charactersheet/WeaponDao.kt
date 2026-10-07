package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.WeaponEntity

@Dao
interface WeaponDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        weapon: WeaponEntity
    ): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(
        weapons: List<WeaponEntity>
    )

    @Update
    suspend fun update(
        weapon: WeaponEntity
    )

    @Delete
    suspend fun delete(
        weapon: WeaponEntity
    )

    @Query("""
        SELECT *
        FROM weapons
        WHERE characterId = :characterId
        ORDER BY name
    """)
    suspend fun getByCharacterId(
        characterId: Long
    ): List<WeaponEntity>

    @Query("""
        SELECT *
        FROM weapons
        WHERE id = :id
    """)
    suspend fun getById(
        id: Long
    ): WeaponEntity?

    @Query("""
        DELETE FROM weapons
        WHERE characterId = :characterId
    """)
    suspend fun deleteByCharacterId(
        characterId: Long
    )
}