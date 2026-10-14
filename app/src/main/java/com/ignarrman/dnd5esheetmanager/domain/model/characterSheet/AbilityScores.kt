package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

import kotlin.math.floor

enum class AbilityScores(
    val statName: String
) {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    INT("Intelligence"),
    WIS("Wisdom"),
    CHA("Charisma")
}

enum class Skill(
    val skillName: String,
    val stat: AbilityScores
) {
    ATHLETICS("Athletics", AbilityScores.STR),
    ACROBATICS("Acrobatics", AbilityScores.DEX),
    STEALTH("Stealth", AbilityScores.DEX),
    SLEIGHT_OF_HAND("Sleight of Hand", AbilityScores.DEX),
    ARCANA("Arcana", AbilityScores.INT),
    INVESTIGATION("Investigation", AbilityScores.INT),
    HISTORY("History", AbilityScores.INT),
    RELIGION("Religion", AbilityScores.INT),
    NATURE("Nature", AbilityScores.INT),
    ANIMAL_HANDLING("Animal Handling", AbilityScores.WIS),
    PERCEPTION("Perception", AbilityScores.WIS),
    INSIGHT("Insight", AbilityScores.WIS),
    SURVIVAL("Survival", AbilityScores.WIS),
    MEDICINE("Medicine", AbilityScores.WIS),
    PERSUASION("Persuasion", AbilityScores.CHA),
    INTIMIDATION("Intimidation", AbilityScores.CHA),
    DECEPTION("DecepTion", AbilityScores.CHA),
    PERFORMANCE("Performance", AbilityScores.CHA)
}

fun getScoreBonus(score: Int): Int{
    return floor(((score-10)/2).toDouble()).toInt()
}

fun getScoreProficiencyBonus(
    score: Int,
    proficiency: Boolean,
    expertise: Boolean,
    proficiencyBonus: Int
): Int {
    val abilityModifier = floor((score - 10) / 2.0).toInt()

    return abilityModifier + when {
        expertise -> proficiencyBonus * 2
        proficiency -> proficiencyBonus
        else -> 0
    }
}