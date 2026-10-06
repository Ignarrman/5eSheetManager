package com.ignarrman.dnd5esheetmanager.data.local.repositories

import com.ignarrman.dnd5esheetmanager.data.local.daos.backgrounds.BackgroundDao
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
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
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
import com.ignarrman.dnd5esheetmanager.data.mappers.toDomain
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
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

    suspend fun getBarbarian(id: Long): Barbarian {

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

    suspend fun getBard(id: Long): Bard {
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

    suspend fun getArtificer(id: Long): Artificer {

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

    suspend fun getCleric(classId: Long): Cleric {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

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

    suspend fun getDruid(classId: Long): Druid {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

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

    suspend fun getFighter(id: Long): Fighter {

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

    suspend fun getMonk(classId: Long): Monk {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

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

    suspend fun getPaladin(classId: Long): Paladin {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

        val fightingStyleCrossRef =
            classDao.getFightingStylesFromClass(classId)

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

    suspend fun getRanger(classId: Long): Ranger {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

        val fightingStyleCrossRef =
            classDao.getFightingStylesFromClass(classId)

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

    suspend fun getRogue(classId: Long): Rogue {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

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

    suspend fun getSorcerer(classId: Long): Sorcerer {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

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

    suspend fun getWarlock(classId: Long): Warlock {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

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

    suspend fun getWizard(classId: Long): Wizard {

        val classEntity =
            classDao.getClass(classId)
                ?: error("Class not found")

        val featureRelations =
            classDao.getFeaturesFromClass(classId)

        val features =
            featureDao.getFeaturesByIds(
                featureRelations.map { it.featureId }
            )

        val spellcasting =
            spellcastingDao.getSpellcasting(classId)
                ?: error("Spellcasting not found")

        val cantripProgression =
            spellcastingDao.getCantripProgression(classId)

        val spellSlotProgression =
            spellcastingDao.getSpellSlotProgression(classId)

        val spellsKnownProgression =
            spellcastingDao.getSpellsKnownProgression(classId)

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