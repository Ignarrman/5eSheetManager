package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background

object FakeBackground {

    val acolyte = Background(
        id = 1L,
        name = "Acolyte",
        skillProficiencies = listOf("Insight", "Religion"),
        languages = "Two languages of your choice",
        equipment = "Holy symbol, prayer book, incense, vestments, common clothes, 15 gp",
        featureId = 1L
    )

    val criminal = Background(
        id = 2L,
        name = "Criminal",
        skillProficiencies = listOf("Deception", "Stealth"),
        languages = null,
        equipment = "Crowbar, dark common clothes with a hood, 15 gp",
        featureId = 2L
    )

    val folkHero = Background(
        id = 3L,
        name = "Folk Hero",
        skillProficiencies = listOf("Animal Handling", "Survival"),
        languages = null,
        equipment = "Artisan's tools, shovel, iron pot, common clothes, 10 gp",
        featureId = 3L
    )

    val noble = Background(
        id = 4L,
        name = "Noble",
        skillProficiencies = listOf("History", "Persuasion"),
        languages = null,
        equipment = "Fine clothes, signet ring, scroll of pedigree, 25 gp",
        featureId = 4L
    )

    val sage = Background(
        id = 5L,
        name = "Sage",
        skillProficiencies = listOf("Arcana", "History"),
        languages = "Two languages of your choice",
        equipment = "Bottle of ink, quill, small knife, letter, common clothes, 10 gp",
        featureId = 5L
    )

    val all = listOf(
        acolyte,
        criminal,
        folkHero,
        noble,
        sage
    )
}