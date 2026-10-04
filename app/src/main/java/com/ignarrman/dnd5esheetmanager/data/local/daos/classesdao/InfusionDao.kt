package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionEntity

@Dao
interface InfusionDao {

    @Query("SELECT * FROM infusions")
    suspend fun getAll(): List<InfusionEntity>

    @Insert
    suspend fun insertAll(infusions: List<InfusionEntity>)

    @Query("DELETE FROM infusions")
    suspend fun deleteAll()
}