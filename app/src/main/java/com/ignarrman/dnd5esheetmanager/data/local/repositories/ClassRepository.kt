package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.FightingStyleDao
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
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ArtificerData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BarbarianData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.BardData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClericData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.DruidData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.FighterData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.PaladinData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.RangerData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.RogueData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.SorcererData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WarlockData
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.WizardData
import com.ignarrman.dnd5esheetmanager.data.local.seed.classes.ClassReferenceData
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Artificer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Barbarian
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Bard
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Cleric
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Druid
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Fighter
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Monk
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Paladin
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Ranger
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Rogue
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Sorcerer
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Warlock
import com.ignarrman.dnd5esheetmanager.domain.model.classes.Wizard
import javax.inject.Inject

class ClassRepository @Inject constructor(
    private val classDao: ClassDao,
    private val featureDao: FeatureDao,
    private val fightingStyleDao: FightingStyleDao,
    private val barbarianProgressionDao: BarbarianProgressionDao,
    private val bardicInspirationProgressionDao: BardicInspirationProgressionDao,
    private val infusionProgressionDao: InfusionProgressionDao,
    private val infusionDao: InfusionDao,
    private val channelDivinityProgressionDao: ChannelDivinityProgressionDao,
    private val wildShapeProgressionDao: WildShapeProgressionDao,
    private val fighterProgressionDao: FighterProgressionDao,
    private val layOnHandsProgressionDao: LayOnHandsProgressionDao,
    private val monkProgressionDao: MonkProgressionDao,
    private val sneakAttackProgressionDao: SneakAttackProgressionDao,
    private val sorceryPointProgressionDao: SorceryPointProgressionDao,
    private val metamagicDao: MetamagicDao,
    private val eldritchInvocationsKnownProgressionDao: EldritchInvocationsKnownProgressionDao,
    private val eldritchInvocationsProgressionDao: EldritchInvocationsProgressionDao,
    private val spellcastingDao: SpellcastingDao,
) {

    suspend fun getIdByName(name: String): Long? {
        return classDao.getClassIdByName(name)
    }

    suspend fun getBarbarian(): Barbarian {

        val id = ClassReferenceData.BARBARIAN_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val relations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                relations.map { it.featureId }
            )

        val progression =
            barbarianProgressionDao.getProgression()

        return BarbarianData(
            classEntity = classEntity,
            featureRelations = relations,
            features = features,
            progression = progression
        ).toDomain()
    }

    suspend fun getBard(): Bard {
        val id = ClassReferenceData.BARD_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val relations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                relations.map { it.featureId }
            )

        val bardicInspirationProgression =
            bardicInspirationProgressionDao.getProgression()

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        return BardData(
            classEntity = classEntity,
            featureRelations = relations,
            features = features,
            bardicInspirationProgression = bardicInspirationProgression,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression
        ).toDomain()
    }

    suspend fun getArtificer(): Artificer {

        val id = ClassReferenceData.ARTIFICER_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featuresRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featuresRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val infusionsList =
            infusionDao.getAll()

        val infusionProgression =
            infusionProgressionDao.getProgression()

        return ArtificerData(
            classEntity = classEntity,
            featureRelations = featuresRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = spellcastingDao.getCantripProgression(id),
            spellSlotProgression = spellcastingDao.getSpellSlotProgression(id),
            spellsKnownProgression = spellcastingDao.getSpellsKnownProgression(id),
            infusions = infusionsList,
            infusionProgression = infusionProgression
        ).toDomain()
    }

    suspend fun getCleric(): Cleric {

        val id = ClassReferenceData.CLERIC_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val channelDivinityProgression =
            channelDivinityProgressionDao.getProgression()

        return ClericData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            channelDivinityProgression = channelDivinityProgression
        ).toDomain()
    }

    suspend fun getDruid(): Druid {

        val id = ClassReferenceData.DRUID_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val wildShapeProgression =
            wildShapeProgressionDao.getProgression()

        return DruidData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            wildShapeProgression = wildShapeProgression
        ).toDomain()
    }

    suspend fun getFighter(): Fighter {

        val id = ClassReferenceData.FIGHTER_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featuresRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featuresRelations.map { it.featureId }
            )

        val fightingStyleRelations =
            classDao.getFightingStylesFromClass(id)

        val fightingStyles =
            fightingStyleDao.getFightingStylesByIds(
                fightingStyleRelations.map { it.fightingStyleId }
            )

        val progression =
            fighterProgressionDao.getProgression()

        return FighterData(
            classEntity = classEntity,
            featureRelations = featuresRelations,
            features = features,
            fightingStyleCrossRef = fightingStyleRelations,
            fightingStyles = fightingStyles,
            fighterProgression = progression
        ).toDomain()
    }

    suspend fun getMonk(): Monk {

        val id = ClassReferenceData.MONK_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val progression =
            monkProgressionDao.getProgression()

        return MonkData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            monkProgression = progression
        ).toDomain()
    }

    suspend fun getPaladin(): Paladin {

        val id = ClassReferenceData.PALADIN_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val fightingStyleCrossRef =
            classDao.getFightingStylesFromClass(id)

        val fightingStyles =
            fightingStyleDao.getFightingStylesByIds(
                fightingStyleCrossRef.map { it.fightingStyleId }
            )

        val layOnHands =
            layOnHandsProgressionDao.getProgression()

        return PaladinData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            fightingStyleCrossRef = fightingStyleCrossRef,
            fightingStyles = fightingStyles,
            layOnHands = layOnHands
        ).toDomain()
    }

    suspend fun getRanger(): Ranger {

        val id = ClassReferenceData.RANGER_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val fightingStyleCrossRef =
            classDao.getFightingStylesFromClass(id)

        val fightingStyles =
            fightingStyleDao.getFightingStylesByIds(
                fightingStyleCrossRef.map { it.fightingStyleId }
            )

        return RangerData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            fightingStyleCrossRef = fightingStyleCrossRef,
            fightingStyles = fightingStyles
        ).toDomain()
    }

    suspend fun getRogue(): Rogue {

        val id = ClassReferenceData.ROGUE_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val sneakAttackProgression =
            sneakAttackProgressionDao.getProgression()

        return RogueData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            sneakAttackProgression = sneakAttackProgression
        ).toDomain()
    }

    suspend fun getSorcerer(): Sorcerer {

        val id = ClassReferenceData.SORCERER_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val sorceryPointProgression =
            sorceryPointProgressionDao.getProgression()

        val metamagics =
            metamagicDao.getAll()

        return SorcererData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            sorceryPointProgression = sorceryPointProgression,
            metamagicList = metamagics
        ).toDomain()
    }

    suspend fun getWarlock(): Warlock {

        val id = ClassReferenceData.WARLOCK_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        val eldritchInvocations =
            eldritchInvocationsProgressionDao.getProgression()

        val eldritchInvocationsKnown =
            eldritchInvocationsKnownProgressionDao.getProgression()

        return WarlockData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression,
            eldritchInvocations = eldritchInvocations,
            eldritchInvocationsKnown = eldritchInvocationsKnown
        ).toDomain()
    }

    suspend fun getWizard(): Wizard {

        val id = ClassReferenceData.WIZARD_ID

        val classEntity =
            classDao.getClass(id)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(id)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(id)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(id)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(id)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(id)

        return WizardData(
            classEntity = classEntity,
            featureRelations = featureRelations,
            features = features,
            spellcasting = spellcasting,
            cantripProgression = cantripProgression,
            spellSlotProgression = spellSlotProgression,
            spellsKnownProgression = spellsKnownProgression
        ).toDomain()
    }

}