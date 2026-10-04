package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase

suspend fun clearClassesReferenceData(database: AppDatabase) {

    // Class-specific progressions
    database.wildShapeProgressionDao().deleteAll()
    database.sorceryPointProgressionDao().deleteAll()
    database.sneakAttackProgressionDao().deleteAll()
    database.monkProgressionDao().deleteAll()
    database.layOnHandsProgressionDao().deleteAll()
    database.infusionProgressionDao().deleteAll()
    database.fighterProgressionDao().deleteAll()
    database.eldritchInvocationsKnownProgressionDao().deleteAll()
    database.eldritchInvocationsProgressionDao().deleteAll()
    database.channelDivinityProgressionDao().deleteAll()
    database.bardicInspirationProgressionDao().deleteAll()
    database.barbarianProgressionDao().deleteAll()

    // Class-specific catalogues
    database.metamagicDao().deleteAll()
    database.infusionDao().deleteAll()

    // Fighting styles
    database.classDao().deleteAllFightingStyles()
    database.fightingStyleDao().deleteAll()

    // Spellcasting
    database.spellcastingDao().deleteAllSpellSlots()
    database.spellcastingDao().deleteAllSpellsKnown()
    database.spellcastingDao().deleteAllCantrips()
    database.spellcastingDao().deleteAllSpellcasting()

    // Class features
    database.classDao().deleteAllFeatures()

    // Classes
    database.classDao().deleteAll()
}

suspend fun insertClassesReferenceData(database: AppDatabase) {

    // Classes
    database.classDao().insertAll(
        ClassReferenceData.classes
    )

    // Features
    database.featureDao().insertAll(
        BarbarianReferenceData.features +
                BardReferenceData.features +
                ArtificerReferenceData.features +
                ClericReferenceData.features +
                DruidReferenceData.features +
                FighterReferenceData.features +
                MonkReferenceData.features +
                PaladinReferenceData.features +
                RangerReferenceData.features +
                RogueReferenceData.features +
                SorcererReferenceData.features +
                WarlockReferenceData.features +
                WizardReferenceData.features
    )

    // Class -> Features
    database.classDao().insertFeatures(
        BarbarianReferenceData.featureRelations +
                BardReferenceData.featureRelations +
                ArtificerReferenceData.featureRelations +
                ClericReferenceData.featureRelations +
                DruidReferenceData.featureRelations +
                FighterReferenceData.featureRelations +
                MonkReferenceData.featureRelations +
                PaladinReferenceData.featureRelations +
                RangerReferenceData.featureRelations +
                RogueReferenceData.featureRelations +
                SorcererReferenceData.featureRelations +
                WarlockReferenceData.featureRelations +
                WizardReferenceData.featureRelations
    )

    // Fighting styles
    database.fightingStyleDao().insertAll(
        FighterReferenceData.fightingStyles +
                PaladinReferenceData.fightingStyles +
                RangerReferenceData.fightingStyles
    )

    database.classDao().insertFightingStyles(
        FighterReferenceData.fightingStyleRelations +
                PaladinReferenceData.fightingStyleRelations +
                RangerReferenceData.fightingStyleRelations
    )

    // Barbarian
    database.barbarianProgressionDao().insertAll(
        BarbarianReferenceData.progression
    )

    // Bard
    database.bardicInspirationProgressionDao().insertAll(
        BardReferenceData.bardicInspiration
    )

    // Artificer
    database.infusionDao().insertAll(
        ArtificerReferenceData.infusions
    )

    database.infusionProgressionDao().insertAll(
        ArtificerReferenceData.infusionProgression
    )

    // Cleric
    database.channelDivinityProgressionDao().insertAll(
        ClericReferenceData.channelDivinityProgression
    )

    // Fighter
    database.fighterProgressionDao().insertAll(
        FighterReferenceData.progression
    )

    // Paladin
    database.layOnHandsProgressionDao().insertAll(
        PaladinReferenceData.layOnHandsProgression
    )

    // Monk
    database.monkProgressionDao().insertAll(
        MonkReferenceData.progression
    )

    // Rogue
    database.sneakAttackProgressionDao().insertAll(
        RogueReferenceData.sneakAttackProgression
    )

    // Sorcerer
    database.sorceryPointProgressionDao().insertAll(
        SorcererReferenceData.sorceryPoints
    )

    database.metamagicDao().insertAll(
        SorcererReferenceData.metamagics
    )

    // Warlock
    database.eldritchInvocationsProgressionDao().insertAll(
        WarlockReferenceData.eldritchInvocations
    )

    database.eldritchInvocationsKnownProgressionDao().insertAll(
        WarlockReferenceData.eldritchInvocationsKnown
    )

    // Druid
    database.wildShapeProgressionDao().insertAll(
        DruidReferenceData.wildShapeProgression
    )

    // Spellcasting
    database.spellcastingDao().insertSpellcasting(
        BardReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        ArtificerReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        ClericReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        DruidReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        PaladinReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        RangerReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        SorcererReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        WarlockReferenceData.spellcasting
    )

    database.spellcastingDao().insertSpellcasting(
        WizardReferenceData.spellcasting
    )

    // Cantrips
    database.spellcastingDao().insertCantrips(
        BardReferenceData.cantrips +
                ArtificerReferenceData.cantrips +
                ClericReferenceData.cantrips +
                DruidReferenceData.cantrips +
                SorcererReferenceData.cantrips +
                WarlockReferenceData.cantrips +
                WizardReferenceData.cantrips
    )

    // Spells known
    database.spellcastingDao().insertSpellsKnown(
        BardReferenceData.spellsKnown +
                ArtificerReferenceData.spellsKnown +
                SorcererReferenceData.spellsKnown +
                WarlockReferenceData.spellsKnown
    )

    // Spell slots
    database.spellcastingDao().insertSpellSlots(
        BardReferenceData.spellSlots +
                ArtificerReferenceData.spellSlots +
                ClericReferenceData.spellSlots +
                DruidReferenceData.spellSlots +
                PaladinReferenceData.spellSlots +
                RangerReferenceData.spellSlots +
                SorcererReferenceData.spellSlots +
                WarlockReferenceData.spellSlots +
                WizardReferenceData.spellSlots
    )
}