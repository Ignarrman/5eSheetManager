package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Coins
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill

object FakeCharacterSheet {

    val arannis = CharacterSheet(
        id = 1L,
        name = "Arannis Moonwhisper",
        level = 5,
        experiencePoints = 6500,
        proficiencyBonus = 3,
        initiative = 3,
        race = FakeRace.elf,
        background = FakeBackground.folkHero,
        playerClassId = 1L,
        stats = mapOf(
            AbilityScores.STR to 8,
            AbilityScores.DEX to 16,
            AbilityScores.CON to 14,
            AbilityScores.INT to 12,
            AbilityScores.WIS to 10,
            AbilityScores.CHA to 18
        ),
        skills = mapOf(
            Skill.ATHLETICS to 5,
            Skill.ACROBATICS to 5,
            Skill.STEALTH to 5,
            Skill.SLEIGHT_OF_HAND to 5,
            Skill.ARCANA to 5,
            Skill.HISTORY to 5,
            Skill.INVESTIGATION to 5,
            Skill.RELIGION to 5,
            Skill.PERCEPTION to 5,
            Skill.MEDICINE to 5,
            Skill.INSIGHT to 5,
            Skill.ANIMAL_HANDLING to 5,
            Skill.SURVIVAL to 5,
            Skill.INTIMIDATION to 5,
            Skill.PERSUASION to 5,
            Skill.DECEPTION to 5,
            Skill.PERFORMANCE to 5,
        ),
        armorClass = 14,
        maxHp = 32,
        currentHp = 27,
        currentHitDice = 5,
        deathSaveSuccesses = 0,
        deathSaveFailures = 0,
        skillProficiencies = listOf(
            Skill.ARCANA,
            Skill.DECEPTION,
            Skill.PERSUASION
        ),
        savingThrowProficiencies = listOf(
            AbilityScores.WIS,
            AbilityScores.CHA
        ),
        notes = "A warlock searching for forbidden knowledge.",
        wallet = mapOf(
            Coins.GOLD to 45,
            Coins.SILVER to 12,
            Coins.COPPER to 8
        )
    )

    val thorin = CharacterSheet(
        id = 2L,
        name = "Thorin Ironforge",
        level = 3,
        experiencePoints = 900,
        proficiencyBonus = 2,
        initiative = 0,
        race = FakeRace.dragonborn,
        background = FakeBackground.acolyte,
        playerClassId = 2L,
        stats = mapOf(
            AbilityScores.STR to 17,
            AbilityScores.DEX to 10,
            AbilityScores.CON to 16,
            AbilityScores.INT to 10,
            AbilityScores.WIS to 13,
            AbilityScores.CHA to 8
        ),
        skills = mapOf(
            Skill.ATHLETICS to 5,
            Skill.ACROBATICS to 5,
            Skill.STEALTH to 5,
            Skill.SLEIGHT_OF_HAND to 5,
            Skill.ARCANA to 5,
            Skill.HISTORY to 5,
            Skill.INVESTIGATION to 5,
            Skill.RELIGION to 5,
            Skill.PERCEPTION to 5,
            Skill.MEDICINE to 5,
            Skill.INSIGHT to 5,
            Skill.ANIMAL_HANDLING to 5,
            Skill.SURVIVAL to 5,
            Skill.INTIMIDATION to 5,
            Skill.PERSUASION to 5,
            Skill.DECEPTION to 5,
            Skill.PERFORMANCE to 5,
        ),
        armorClass = 18,
        maxHp = 31,
        currentHp = 31,
        currentHitDice = 3,
        deathSaveSuccesses = 2,
        deathSaveFailures = 1,
        skillProficiencies = listOf(
            Skill.ATHLETICS,
            Skill.INTIMIDATION
        ),
        savingThrowProficiencies = listOf(
            AbilityScores.STR,
            AbilityScores.CON
        ),
        notes = "A stubborn warrior who never abandons an ally.",
        wallet = mapOf(
            Coins.GOLD to 12,
            Coins.SILVER to 5
        )
    )

    val elara = CharacterSheet(
        id = 3L,
        name = "Elara Starweaver",
        level = 7,
        experiencePoints = 23000,
        proficiencyBonus = 3,
        initiative = 2,
        race = FakeRace.dwarf,
        background = FakeBackground.acolyte,
        playerClassId = 3L,
        stats = mapOf(
            AbilityScores.STR to 8,
            AbilityScores.DEX to 14,
            AbilityScores.CON to 12,
            AbilityScores.INT to 20,
            AbilityScores.WIS to 15,
            AbilityScores.CHA to 11
        ),
        skills = mapOf(
            Skill.ATHLETICS to 5,
            Skill.ACROBATICS to 5,
            Skill.STEALTH to 5,
            Skill.SLEIGHT_OF_HAND to 5,
            Skill.ARCANA to 5,
            Skill.HISTORY to 5,
            Skill.INVESTIGATION to 5,
            Skill.RELIGION to 5,
            Skill.PERCEPTION to 5,
            Skill.MEDICINE to 5,
            Skill.INSIGHT to 5,
            Skill.ANIMAL_HANDLING to 5,
            Skill.SURVIVAL to 5,
            Skill.INTIMIDATION to 5,
            Skill.PERSUASION to 5,
            Skill.DECEPTION to 5,
            Skill.PERFORMANCE to 5,
        ),
        armorClass = 12,
        maxHp = 37,
        currentHp = 19,
        temporaryHp = 5,
        currentHitDice = 7,
        deathSaveSuccesses = 0,
        deathSaveFailures = 0,
        skillProficiencies = listOf(
            Skill.ARCANA,
            Skill.HISTORY,
            Skill.INVESTIGATION
        ),
        skillExpertise = listOf(
            Skill.ARCANA
        ),
        savingThrowProficiencies = listOf(
            AbilityScores.INT,
            AbilityScores.WIS
        ),
        notes = "A scholar fascinated by ancient magical civilizations.",
        wallet = mapOf(
            Coins.GOLD to 120,
            Coins.SILVER to 30,
            Coins.COPPER to 14
        )
    )

    val shadowmere = CharacterSheet(
        id = 4L,
        name = "Shadowmere",
        level = 5,
        experiencePoints = 0,
        proficiencyBonus = 2,
        initiative = 3,
        race = FakeRace.human,
        background = FakeBackground.criminal,
        playerClassId = 4L,
        stats = mapOf(
            AbilityScores.STR to 10,
            AbilityScores.DEX to 16,
            AbilityScores.CON to 13,
            AbilityScores.INT to 14,
            AbilityScores.WIS to 12,
            AbilityScores.CHA to 14
        ),
        skills = mapOf(
            Skill.ATHLETICS to 5,
            Skill.ACROBATICS to 5,
            Skill.STEALTH to 5,
            Skill.SLEIGHT_OF_HAND to 5,
            Skill.ARCANA to 5,
            Skill.HISTORY to 5,
            Skill.INVESTIGATION to 5,
            Skill.RELIGION to 5,
            Skill.PERCEPTION to 5,
            Skill.MEDICINE to 5,
            Skill.INSIGHT to 5,
            Skill.ANIMAL_HANDLING to 5,
            Skill.SURVIVAL to 5,
            Skill.INTIMIDATION to 5,
            Skill.PERSUASION to 5,
            Skill.DECEPTION to 5,
            Skill.PERFORMANCE to 5,
        ),
        armorClass = 14,
        maxHp = 10,
        currentHp = 6,
        currentHitDice = 1,
        deathSaveSuccesses = 2,
        deathSaveFailures = 1,
        spellSlotUsed = FakeSpentSpellSlots.partial,
        skillProficiencies = listOf(
            Skill.STEALTH,
            Skill.ACROBATICS,
            Skill.PERCEPTION
        ),
        skillExpertise = listOf(
            Skill.STEALTH,
            Skill.ACROBATICS,
        ),
        savingThrowProficiencies = listOf(
            AbilityScores.DEX,
            AbilityScores.INT
        ),
        feats = FakeFeats.all,
        spells = FakeSpells.all,
        temporaryHp = 2,
        notes = FakeNotes.notes,
        wallet = mapOf(
            Coins.GOLD to 5,
            Coins.SILVER to 10
        )
    )

    val emptyCharacter = CharacterSheet(
        id = null,
        name = "",
        level = 1,
        experiencePoints = 0,
        proficiencyBonus = 2
    )

    val all = listOf(
        arannis,
        thorin,
        elara,
        shadowmere
    )
}