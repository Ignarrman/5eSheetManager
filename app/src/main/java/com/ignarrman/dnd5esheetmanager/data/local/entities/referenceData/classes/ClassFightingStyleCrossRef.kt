package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "class_fighting_styles",
    primaryKeys = ["classId", "fightingStyleId"],
    foreignKeys = [
        ForeignKey(
            entity = ClassEntity::class,
            parentColumns = ["id"],
            childColumns = ["classId"]
        ),
        ForeignKey(
            entity = FightingStyleEntity::class,
            parentColumns = ["id"],
            childColumns = ["fightingStyleId"]
        )
    ]
)
data class ClassFightingStyleCrossRef(
    val classId: Long,
    val fightingStyleId: Long
)
