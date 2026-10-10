package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WildShapeProgressionEntity

@Dao
interface WildShapeProgressionDao {

    @Query("SELECT * FROM wild_shape_progression ORDER BY level")
    suspend fun getProgression(): List<WildShapeProgressionEntity>

    @Insert
    suspend fun insertAll(progression: List<WildShapeProgressionEntity>)

    @Query("DELETE FROM wild_shape_progression")
    suspend fun deleteAll()
}