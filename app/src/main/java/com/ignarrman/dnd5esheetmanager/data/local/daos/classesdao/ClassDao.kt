package com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef

@Dao
interface ClassDao {

    @Query("SELECT * FROM classes WHERE id = :classId")
    suspend fun getClass(classId: Long): ClassEntity?

    @Query(" SELECT * FROM class_features WHERE classId = :classId ORDER BY level")
    suspend fun getFeaturesFromClass(classId: Long): List<ClassFeatureCrossRef>


    @Query(" SELECT * FROM class_fighting_styles WHERE classId = :classId")
    suspend fun getFightingStylesFromClass(classId: Long): List<ClassFightingStyleCrossRef>

    @Insert
    suspend fun insertAll(classes: List<ClassEntity>)

    @Insert
    suspend fun insertFeatures(relations: List<ClassFeatureCrossRef>)

    @Insert
    suspend fun insertFightingStyles(relations: List<ClassFightingStyleCrossRef>)

    @Query("DELETE FROM class_features")
    suspend fun deleteAllFeatures()

    @Query("DELETE FROM class_fighting_styles")
    suspend fun deleteAllFightingStyles()

    @Query("DELETE FROM classes")
    suspend fun deleteAll()

}