package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import androidx.room.ForeignKey
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity

@Entity(
    tableName = "class_features",
    primaryKeys = ["classId", "featureId", "level"],
    foreignKeys = [
        ForeignKey(
            entity = ClassEntity::class,
            parentColumns = ["id"],
            childColumns = ["classId"]
        ),
        ForeignKey(
            entity = FeatureEntity::class,
            parentColumns = ["id"],
            childColumns = ["featureId"]
        )
    ]
)
data class ClassFeatureCrossRef(
    val classId: Long,
    val featureId: Long,
    val level: Int
)
