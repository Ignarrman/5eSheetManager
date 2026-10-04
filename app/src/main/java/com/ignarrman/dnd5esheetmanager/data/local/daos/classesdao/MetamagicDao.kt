package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MetamagicEntity

@Dao
interface MetamagicDao {

    @Query("SELECT * FROM metamagics")
    suspend fun getAll(): List<MetamagicEntity>

    @Insert
    suspend fun insertAll(metamagics: List<MetamagicEntity>)

    @Query("DELETE FROM metamagics")
    suspend fun deleteAll()
}