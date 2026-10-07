package com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.CharacterSheetEntity

@Dao
interface CharacterSheetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterSheetEntity): Long

    @Update
    suspend fun update(character: CharacterSheetEntity)

    @Delete
    suspend fun delete(character: CharacterSheetEntity)

    @Query("""
        SELECT * FROM character_sheets
        ORDER BY name
    """)
    suspend fun getAll(): List<CharacterSheetEntity>

    @Query("""
        SELECT * FROM character_sheets
        WHERE id = :id
    """)
    suspend fun getById(id: Long): CharacterSheetEntity?

    @Query("""
        DELETE FROM character_sheets
        WHERE id = :id
    """)
    suspend fun deleteById(id: Long)
}
