package com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpellDao {

    @Query("SELECT * FROM spells")
    fun getAll(): Flow<List<SpellEntity>>

    @Query("SELECT * FROM spells WHERE name = :name")
    suspend fun getByName(name: String): SpellEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(spells: List<SpellEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spell: SpellEntity)
}