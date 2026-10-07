package com.ignarrman.dnd5esheetmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds.BackgroundDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.FightingStyleDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.ReferenceDataMetadataDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.charactersheet.ProficiencyBonusProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BardicInspirationProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ChannelDivinityProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.EldritchInvocationsKnownProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.EldritchInvocationsProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.FighterProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.InfusionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.InfusionProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.LayOnHandsProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.MetamagicDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.MonkProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.SneakAttackProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.SorceryPointProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.WildShapeProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.featsdao.FeatDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.races.RaceDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.characterData.ProficiencyBonusProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.backgrounds.BackgroundEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.ReferenceDataMetadataEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardicInspirationProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ChannelDivinityProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFightingStyleCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.EldritchInvocationsKnownProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FightingStyleEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.InfusionProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.LayOnHandsProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MetamagicEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SneakAttackProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SorceryPointProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WildShapeProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.feats.FeatEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.CantripProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellSlotProgressionEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellcastingEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.spells.SpellsKnownProgressionEntity

@Database(
    entities = [
        ProficiencyBonusProgressionEntity::class,

        ClassEntity::class,
        FeatureEntity::class,
        ClassFeatureCrossRef::class,
        BackgroundEntity::class,
        RaceEntity::class,
        FeatEntity::class,

        FightingStyleEntity::class,
        ClassFightingStyleCrossRef::class,

        BarbarianProgressionEntity::class,
        BardicInspirationProgressionEntity::class,
        ChannelDivinityProgressionEntity::class,
        FighterProgressionEntity::class,
        InfusionEntity::class,
        InfusionProgressionEntity::class,
        LayOnHandsProgressionEntity::class,
        MonkProgressionEntity::class,
        SneakAttackProgressionEntity::class,
        SorceryPointProgressionEntity::class,
        MetamagicEntity::class,
        WildShapeProgressionEntity::class,
        EldritchInvocationsEntity::class,
        EldritchInvocationsKnownProgressionEntity::class,

        SpellcastingEntity::class,
        CantripProgressionEntity::class,
        SpellSlotProgressionEntity::class,
        SpellsKnownProgressionEntity::class,
        SpellEntity::class,

        ReferenceDataMetadataEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun proficiencyBonusDao(): ProficiencyBonusProgressionDao
    abstract fun classDao(): ClassDao
    abstract fun featureDao(): FeatureDao
    abstract fun backgroundDao(): BackgroundDao
    abstract fun raceDao(): RaceDao
    abstract fun featDao(): FeatDao
    abstract fun fightingStyleDao(): FightingStyleDao
    abstract fun barbarianProgressionDao(): BarbarianProgressionDao
    abstract fun bardicInspirationProgressionDao(): BardicInspirationProgressionDao
    abstract fun channelDivinityProgressionDao(): ChannelDivinityProgressionDao
    abstract fun fighterProgressionDao(): FighterProgressionDao
    abstract fun infusionDao(): InfusionDao
    abstract fun infusionProgressionDao(): InfusionProgressionDao
    abstract fun layOnHandsProgressionDao(): LayOnHandsProgressionDao
    abstract fun monkProgressionDao(): MonkProgressionDao
    abstract fun sneakAttackProgressionDao(): SneakAttackProgressionDao
    abstract fun sorceryPointProgressionDao(): SorceryPointProgressionDao
    abstract fun metamagicDao(): MetamagicDao
    abstract fun wildShapeProgressionDao(): WildShapeProgressionDao
    abstract fun eldritchInvocationsProgressionDao(): EldritchInvocationsProgressionDao
    abstract fun eldritchInvocationsKnownProgressionDao(): EldritchInvocationsKnownProgressionDao
    abstract fun spellcastingDao(): SpellcastingDao
    abstract fun spellDao(): SpellDao
    abstract fun referenceDataMetadataDao(): ReferenceDataMetadataDao
}