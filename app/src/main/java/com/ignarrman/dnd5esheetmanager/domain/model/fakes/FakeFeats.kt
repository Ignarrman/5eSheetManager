package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat

object FakeFeats {

    val alert = Feat(
        id = 1L,
        name = "Alert",
        description = "You gain a +5 bonus to initiative and cannot be surprised while conscious.",
        prerequisite = "None",
        abilityBonus = "None"
    )

    val athlete = Feat(
        id = 2L,
        name = "Athlete",
        description = "You improve your physical mobility, including climbing and recovering from being prone.",
        prerequisite = "None",
        abilityBonus = "+1 Strength or Dexterity"
    )

    val greatWeaponMaster = Feat(
        id = 3L,
        name = "Great Weapon Master",
        description = "You specialize in powerful attacks with heavy weapons.",
        prerequisite = "Proficiency with a martial weapon",
        abilityBonus = "None"
    )

    val lucky = Feat(
        id = 4L,
        name = "Lucky",
        description = "You gain luck points that can be spent to influence attack rolls, ability checks, or saving throws.",
        prerequisite = "None",
        abilityBonus = "None"
    )

    val resilient = Feat(
        id = 5L,
        name = "Resilient",
        description = "You improve one ability score and gain proficiency in saving throws using that ability.",
        prerequisite = "None",
        abilityBonus = "+1 to one ability score"
    )

    val all = listOf(
        alert,
        athlete,
        greatWeaponMaster,
        lucky,
        resilient
    )
}