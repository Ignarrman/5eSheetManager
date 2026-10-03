package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells

import androidx.room.Entity
import androidx.room.ForeignKey
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity

@Entity(
    tableName = "spellcasting",
    primaryKeys = ["classId"],
    foreignKeys = [
        ForeignKey(
            entity = ClassEntity::class,
            parentColumns = ["id"],
            childColumns = ["classId"]
        )
    ]
)
data class SpellcastingEntity(
    val classId: Long,
    val spellcastingAbility: String
)


@Entity(
    tableName = "cantrip_progression",
    primaryKeys = ["classId", "level"],
    foreignKeys = [
        ForeignKey(
            entity = SpellcastingEntity::class,
            parentColumns = ["classId"],
            childColumns = ["classId"]
        )
    ]
)
data class CantripProgressionEntity(
    val classId: Long,
    val level: Int,
    val known: Int
)


@Entity(
    tableName = "spell_slot_progression",
    primaryKeys = ["classId", "level", "slotLevel"],
    foreignKeys = [
        ForeignKey(
            entity = SpellcastingEntity::class,
            parentColumns = ["classId"],
            childColumns = ["classId"]
        )
    ]
)
data class SpellSlotProgressionEntity(
    val classId: Long,
    val level: Int,
    val slotLevel: Int,
    val slots: Int
)

@Entity(
    tableName = "spells_known_progression",
    primaryKeys = ["classId", "level"],
    foreignKeys = [
        ForeignKey(
            entity = SpellcastingEntity::class,
            parentColumns = ["classId"],
            childColumns = ["classId"]
        )
    ]
)
data class SpellsKnownProgressionEntity(
    val classId: Long,
    val level: Int,
    val known: Int
)
