package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import com.ignarrman.dnd5esheetmanager.data.local.repositories.BackgroundRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.ClassRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatureRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.ItemRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.RaceRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.SpellRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.WeaponRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import javax.inject.Inject

class ReferenceDataLoader @Inject constructor(
    private val raceRepository: RaceRepository,
    private val classRepository: ClassRepository,
    private val featRepository: FeatRepository,
    private val backgroundRepository: BackgroundRepository,
    private val itemRepository: ItemRepository,
    private val weaponRepository: WeaponRepository,
    private val featureRepository: FeatureRepository,
    private val spellRepository: SpellRepository
) {
    suspend fun loadRaces(): List<Race> =
        raceRepository.getAll()

    suspend fun loadClasses(): List<PlayerClass> {

        val artificer = classRepository.getArtificer()
        val barbarian = classRepository.getBarbarian()
        val bard = classRepository.getBard()
        val cleric = classRepository.getCleric()
        val druid = classRepository.getDruid()
        val fighter = classRepository.getFighter()
        val monk = classRepository.getMonk()
        val paladin = classRepository.getPaladin()
        val ranger = classRepository.getRanger()
        val rogue = classRepository.getRogue()
        val sorcerer = classRepository.getSorcerer()
        val warlock = classRepository.getWarlock()
        val wizard = classRepository.getWizard()

        return listOf(artificer,barbarian,bard,cleric,druid,fighter,monk,paladin,ranger,rogue,sorcerer,warlock,wizard).sortedBy { it.id }
    }

    suspend fun loadBackground(): List<Background> =
        backgroundRepository.getAll()

    suspend fun loadFeats(): List<Feat> =
        featRepository.getAll()

    suspend fun loadCharacterItems(characterId: Long): List<Item> =
        itemRepository.getByCharacterId(characterId = characterId)

    suspend fun loadCharacterWeapons(characterId: Long): List<Weapon> =
        weaponRepository.getByCharacterId(characterId = characterId)

    suspend fun getFeature(featureId: Long): Feature? =
        featureRepository.getById(featureId)

    suspend fun getFeatures(featuresIds: List<Long>): List<Feature> =
        featureRepository.getByIds(ids = featuresIds)

    suspend fun loadSpells(): List<Spell> =
        spellRepository.getAll()

    suspend fun loadSpell(spellName: String): Spell? =
        spellRepository.getByName(spellName)
}