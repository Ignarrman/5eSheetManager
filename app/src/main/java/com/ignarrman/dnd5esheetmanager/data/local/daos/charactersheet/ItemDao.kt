package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ItemEntity

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        item: ItemEntity
    ): Long

    @Query("""
        DELETE FROM items
        WHERE id = :id
    """)
    suspend fun deleteById(id: Long)

    @Query("""
        SELECT *
        FROM items
        WHERE characterId = :characterId
        ORDER BY name
    """)
    suspend fun getByCharacterId(
        characterId: Long
    ): List<ItemEntity>

    @Query("""
        DELETE FROM items
        WHERE characterId = :characterId
    """)
    suspend fun deleteByCharacterId(
        characterId: Long
    )
}