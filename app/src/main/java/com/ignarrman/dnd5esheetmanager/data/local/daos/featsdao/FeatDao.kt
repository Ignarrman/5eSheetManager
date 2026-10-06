package com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity

@Dao
interface FeatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(feats: List<FeatEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(feat: FeatEntity)

    @Query("SELECT * FROM feats ORDER BY name")
    suspend fun getAll(): List<FeatEntity>

    @Query("SELECT * FROM feats WHERE id = :id")
    suspend fun getById(id: Long): FeatEntity?

    @Query("SELECT * FROM feats WHERE name = :name ORDER BY id")
    suspend fun getByName(name: String): List<FeatEntity>

    @Query("DELETE FROM feats")
    suspend fun deleteAll()
}