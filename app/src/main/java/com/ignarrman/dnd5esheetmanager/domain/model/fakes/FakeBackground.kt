package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeatures.criminalContact
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeatures.rusticHospitality
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeatures.shelterOfTheFaithful

object FakeBackground {

    val acolyte = Background(
        id = 1L,
        name = "Acolyte",
        skillProficiencies = listOf("Insight", "Religion"),
        languages = "Two languages of your choice",
        equipment = "Holy symbol, prayer book, incense, vestments, common clothes, 15 gp",
        feature = shelterOfTheFaithful
    )

    val criminal = Background(
        id = 2L,
        name = "Criminal",
        skillProficiencies = listOf("Deception", "Stealth"),
        languages = null,
        equipment = "Crowbar, dark common clothes with a hood, 15 gp",
        feature = criminalContact
    )

    val folkHero = Background(
        id = 3L,
        name = "Folk Hero",
        skillProficiencies = listOf("Animal Handling", "Survival"),
        languages = null,
        equipment = "Artisan's tools, shovel, iron pot, common clothes, 10 gp",
        feature = rusticHospitality
    )

    val all = listOf(
        acolyte,
        criminal,
        folkHero,
    )
}