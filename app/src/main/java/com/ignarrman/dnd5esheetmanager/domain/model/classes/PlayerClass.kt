package com.ignarrman.dnd5esheetmanager.domain.model.classes

import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.ClassReferenceData
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spellcasting

open class PlayerClass(
    open val id: Long? = null,
    open val name: String,
    open val hitDice: Int,
    open val features: Map<Int, List<Feature>>,
    open val fightingStyleIds: List<Long> = emptyList(),
    open val spellcasting: Spellcasting = Spellcasting.NonCaster
)

data class FightingStyle(
    val id: Long? = null,
    val name: String,
    val description: String
)

fun getClassName(classId: Long?): String {
    return when (classId) {
        ClassReferenceData.BARBARIAN_ID -> "Barbarian"
        ClassReferenceData.BARD_ID -> "Bard"
        ClassReferenceData.ARTIFICER_ID -> "Artificer"
        ClassReferenceData.CLERIC_ID -> "Cleric"
        ClassReferenceData.DRUID_ID -> "Druid"
        ClassReferenceData.FIGHTER_ID -> "Fighter"
        ClassReferenceData.MONK_ID -> "Monk"
        ClassReferenceData.PALADIN_ID -> "Paladin"
        ClassReferenceData.RANGER_ID -> "Ranger"
        ClassReferenceData.ROGUE_ID -> "Rogue"
        ClassReferenceData.SORCERER_ID -> "Sorcerer"
        ClassReferenceData.WARLOCK_ID -> "Warlock"
        ClassReferenceData.WIZARD_ID -> "Wizard"
        else -> "Unknown class"
    }
}