package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spells")
data class SpellEntity(
    @PrimaryKey
    val name: String,
    val level: Int,
    val school: String,
    val castingTime: String,
    val range: String,
    val verbal: Boolean,
    val somatic: Boolean,
    val material: String?,
    val duration: String,
    val concentration: Boolean,
    val ritual: Boolean,
    val description: String,
    val source: String
)
