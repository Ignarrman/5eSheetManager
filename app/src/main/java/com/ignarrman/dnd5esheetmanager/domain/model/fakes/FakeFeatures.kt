package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.Feature

object FakeFeatures {

    // CLASS FEATURES

    val rage = Feature(
        id = 1001L,
        name = "Rage",
        description = "Enter a battle rage to fight with extra resilience and power. " +
                "While raging, you gain benefits to melee attacks using Strength and resistance " +
                "to bludgeoning, piercing, and slashing damage."
    )

    val secondWind = Feature(
        id = 1002L,
        name = "Second Wind",
        description = "You have a limited reserve of stamina that you can draw upon to " +
                "protect yourself. On your turn, you can use a bonus action to regain hit points."
    )

    val bardicInspiration = Feature(
        id = 1003L,
        name = "Bardic Inspiration",
        description = "You can inspire others through stirring words or music. A creature " +
                "that hears you can gain a die to add to an ability check, attack roll, or saving throw."
    )

    val sneakAttack = Feature(
        id = 1004L,
        name = "Sneak Attack",
        description = "You know how to strike subtly and exploit a foe's distraction, " +
                "dealing extra damage when the conditions for Sneak Attack are met."
    )

    val allClass = mapOf(
        1 to listOf(rage),
        2 to listOf(secondWind),
        3 to listOf(bardicInspiration),
        6 to listOf(sneakAttack)
    )


    // RACE FEATURES

    val darkvision = Feature(
        id = 14001L,
        name = "Darkvision",
        description = "Accustomed to life underground, you can see in dim light within " +
                "60 feet of you as if it were bright light, and in darkness as if it were dim light."
    )

    val feyAncestry = Feature(
        id = 14002L,
        name = "Fey Ancestry",
        description = "You have advantage on saving throws against being charmed, " +
                "and magic cannot put you to sleep."
    )

    val dwarvenResilience = Feature(
        id = 14003L,
        name = "Dwarven Resilience",
        description = "You have advantage on saving throws against poison, and you have " +
                "resistance against poison damage."
    )

    val lucky = Feature(
        id = 14004L,
        name = "Lucky",
        description = "Your people have inexplicable good fortune, granting you a small " +
                "measure of luck when things go wrong."
    )

    val allRace = listOf(
        darkvision,
        feyAncestry,
        dwarvenResilience,
        lucky
    )


    // BACKGROUND FEATURES

    val shelterOfTheFaithful = Feature(
        id = 15001L,
        name = "Shelter of the Faithful",
        description = "As an acolyte, you command the respect of those who share your faith. " +
                "You can receive free healing and care at temples of your faith, though you must " +
                "provide any material components needed for spells."
    )

    val criminalContact = Feature(
        id = 15002L,
        name = "Criminal Contact",
        description = "You have a reliable and trustworthy contact who acts as your liaison " +
                "to a network of criminals."
    )

    val rusticHospitality = Feature(
        id = 15003L,
        name = "Rustic Hospitality",
        description = "Since you come from the ranks of the common folk, you can find a place " +
                "to hide, rest, or recuperate among them unless you have shown yourself to be a danger."
    )

    val allBackground = listOf(
        shelterOfTheFaithful,
        criminalContact,
        rusticHospitality
    )


    // ALL FEATURES

    val all = allRace + allBackground
}