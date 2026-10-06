package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races

import androidx.room.PrimaryKey
import androidx.room.Entity
import com.ignarrman.dnd5esheetmanager.domain.model.Feature

@Entity(tableName = "races")
data class RaceEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val size: String,
    val landSpeed: Int,
    val swimSpeed: Int?,
    val climbSpeed: Int?,
    val flySpeed: Int?
)

@Entity(
    tableName = "race_features",
    primaryKeys = ["raceId", "featureId"]
)
data class RaceFeatureCrossRef(
    val raceId: Long,
    val featureId: Long
)
