package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feats")
data class FeatEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val prerequisite: String,
    val abilityBonus: String
)
