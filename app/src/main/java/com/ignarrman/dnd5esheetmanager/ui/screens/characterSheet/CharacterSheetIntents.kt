package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell

sealed interface CharacterSheetIntents {

    data class LoadCharacter(val id: Long): CharacterSheetIntents
    data class UpdateCharacter(val characterSheet: CharacterSheet): CharacterSheetIntents

    data object LoadRaces: CharacterSheetIntents
    data object LoadBackgrounds: CharacterSheetIntents

    data object LoadClasses: CharacterSheetIntents
    data object LoadFeats: CharacterSheetIntents
    data class AddFeat(val characterId: Long, val feat: Feat): CharacterSheetIntents
    data class RemoveFeat(val characterId: Long, val featId: Long): CharacterSheetIntents

    data object LoadSpells: CharacterSheetIntents
    data class AddSpell(val characterId: Long, val spell: Spell): CharacterSheetIntents
    data class RemoveSpell(val characterId: Long, val spellId: Long): CharacterSheetIntents

    data class LoadItems(val characterId: Long): CharacterSheetIntents
    data class AddItem(val characterId: Long, val item: Item): CharacterSheetIntents
    data class RemoveItem(val characterId: Long, val itemId: Long): CharacterSheetIntents

    data class LoadWeapons(val characterId: Long): CharacterSheetIntents
    data class AddWeapon(val characterId: Long, val weapon: Weapon): CharacterSheetIntents
    data class RemoveWeapon(val characterId: Long, val weaponId: Long): CharacterSheetIntents
    data class UpdateWeapon(val characterId: Long, val weapon: Weapon): CharacterSheetIntents
}