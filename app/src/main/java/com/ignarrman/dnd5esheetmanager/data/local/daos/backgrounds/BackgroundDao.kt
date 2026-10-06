package com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundEntity

@Dao
interface BackgroundDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(backgrounds: List<BackgroundEntity>)

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(background: BackgroundEntity)

    @Query("SELECT * FROM backgrounds ORDER BY name")
    suspend fun getAll(): List<BackgroundEntity>

    @Query("SELECT * FROM backgrounds WHERE name = :name")
    suspend fun getByName(name: String): BackgroundEntity?

    @Query("DELETE FROM backgrounds")
    suspend fun deleteAll()
}