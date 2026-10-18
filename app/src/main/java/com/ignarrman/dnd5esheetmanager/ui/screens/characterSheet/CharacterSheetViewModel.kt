package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.BackgroundStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.CharacterSheetStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.ClassStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.FeatStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.InventoryStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.RaceStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.SpellStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.WeaponStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharacterSheetScreenData(
    val characterSheet: CharacterSheet,
    val classes: List<PlayerClass> = emptyList(),
    val races: List<Race>,
    val backgrounds: List<Background>,
    val spells: List<Spell>,
    val inventory: List<Item>,
    val weapons: List<Weapon>
)

@HiltViewModel
class CharacterSheetViewModel @Inject constructor(
    private val characterSheetHolder: CharacterSheetStateHolder,
    private val classStateHolder: ClassStateHolder,
    private val raceStateHolder: RaceStateHolder,
    private val backgroundStateHolder: BackgroundStateHolder,
    private val featStateHolder: FeatStateHolder,
    private val spellStateHolder: SpellStateHolder,
    private val inventoryStateHolder: InventoryStateHolder,
    private val weaponStateHolder: WeaponStateHolder
) : ViewModel() {

    val characterState = characterSheetHolder.state
    val classesState = classStateHolder.state
    val featState = featStateHolder.state
    val spellsState = spellStateHolder.state
    val inventoryState = inventoryStateHolder.state
    val racesState = raceStateHolder.state
    val weaponsState = weaponStateHolder.state
    val backgroundsState = backgroundStateHolder.state

    fun handleIntent(intent: CharacterSheetIntents) {
        when(intent) {

            is CharacterSheetIntents.LoadCharacter -> {
                viewModelScope.launch {
                    characterSheetHolder.loadCharacter(intent.id)
                }
            }

            is CharacterSheetIntents.UpdateCharacter -> {
                viewModelScope.launch {
                    characterSheetHolder.updateCharacter(characterState.value.characterSheet)
                }
            }

            is CharacterSheetIntents.LoadClasses -> {
                viewModelScope.launch {
                    classStateHolder.loadAllClasses()
                }
            }


            is CharacterSheetIntents.LoadRaces -> {
                viewModelScope.launch {
                    raceStateHolder.loadAllRaces()
                }
            }

            is CharacterSheetIntents.LoadSpells -> {
                viewModelScope.launch {
                    spellStateHolder.loadAllSpells()
                }
            }

            is CharacterSheetIntents.AddSpell -> {
                viewModelScope.launch {
                    spellStateHolder.insertSpell(intent.characterId, intent.spell)
                }
            }
            is CharacterSheetIntents.RemoveSpell -> {
                viewModelScope.launch {
                    spellStateHolder.deleteSpell(intent.characterId, intent.spellId)
                }
            }

            is CharacterSheetIntents.LoadBackgrounds -> {
                viewModelScope.launch {
                    backgroundStateHolder.loadAllBackgrounds()
                }
            }

            is CharacterSheetIntents.LoadFeats -> {
                viewModelScope.launch {
                    featStateHolder.loadAllFeats()
                }
            }

            is CharacterSheetIntents.AddFeat -> {
                viewModelScope.launch {
                    featStateHolder.insertFeat(intent.characterId, intent.feat)
                }
            }

            is CharacterSheetIntents.RemoveFeat -> {
                viewModelScope.launch {
                    featStateHolder.deleteFeat(intent.characterId, intent.featId)
                }
            }

            is CharacterSheetIntents.LoadItems -> {
                viewModelScope.launch {
                    inventoryStateHolder.loadAllItems(intent.characterId)
                }
            }

            is CharacterSheetIntents.AddItem -> {
                viewModelScope.launch {
                    inventoryStateHolder.insertItem(intent.characterId, intent.item)
                }
            }

            is CharacterSheetIntents.RemoveItem -> {
                viewModelScope.launch {
                    inventoryStateHolder.deleteItem(intent.characterId, intent.itemId)
                }
            }

            is CharacterSheetIntents.LoadWeapons -> {
                viewModelScope.launch {
                    weaponStateHolder.loadAllWeapons(intent.characterId)
                }
            }

            is CharacterSheetIntents.UpdateWeapon -> {
                viewModelScope.launch {
                    weaponStateHolder.updateWeapon(intent.characterId, intent.weapon)
                }
            }

            is CharacterSheetIntents.AddWeapon -> {
                viewModelScope.launch {
                    weaponStateHolder.insertWeapon(intent.characterId, intent.weapon)
                }
            }

            is CharacterSheetIntents.RemoveWeapon -> {
                viewModelScope.launch {
                    weaponStateHolder.deleteWeapon(intent.characterId, intent.weaponId)
                }

            }
        }
    }
}