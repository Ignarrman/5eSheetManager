package com.ignarrman.dnd5esheetmanager.data.local.entities.characterData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapons")
data class WeaponEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val name: String,
    val description: String,
    val price: Int,
    val quantity: Int,
    val damage: String,
    val rangeType: String,
    val masteryType: String,
    val damageType: String,
    val normalRange: Int?,
    val longRange: Int?,
    val proficient: Boolean,
    val attackBonus: Int,
    val damageBonus: Int,
    val properties: String
)
