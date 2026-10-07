package com.ignarrman.dnd5esheetmanager.data.local.entities.characterData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proficiency_bonus_progression")
data class ProficiencyBonusProgressionEntity(
    @PrimaryKey
    val level: Int,
    val bonus: Int
)
