package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

data class CharacterSheet(
    val id: Long? = null,
    val portraitUri: String? = null,
    val name: String = "",
    val level: Int = 1,
    val experiencePoints: Int = 0,
    val proficiencyBonus: Int = 2,
    val initiative: Int? = null,

    val stats: Map<AbilityScores, Int> = emptyMap(),
    val skills: Map<Skill, Int> = emptyMap(),

    val raceId: Long? = null,
    val backgroundId: Long? = null,
    val playerClassId: Long? = null,
    val featsId: List<Long> = emptyList(),
    val spellsId: List<Long> = emptyList(),

    val armorClass: Int? = null,

    val maxHp: Int? = null,
    val currentHp: Int? = null,
    val temporaryHp: Int = 0,

    val deathSaveSuccesses: Int = 0,
    val deathSaveFailures: Int = 0,

    val currentHitDice: Int = 0,

    val skillProficiencies: List<Skill> = emptyList(),
    val skillExpertise: List<Skill> = emptyList(),
    val savingThrowProficiencies: List<AbilityScores> = emptyList(),
    val proficiencies: List<String> = emptyList(),

    val notes: String = "",

    val wallet: Map<Coins, Int> = emptyMap()
) {
    companion object {
        val Empty = CharacterSheet()
    }
}