package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ignarrman.dnd5esheetmanager.data.local.repositories.CharacterSheetRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.BackgroundStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.CharacterSheetStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.ClassStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.InventoryStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.RaceStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.SpellStateHolder
import com.ignarrman.dnd5esheetmanager.ui.screens.stateholders.WeaponStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
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
    private val spellStateHolder: SpellStateHolder,
    private val inventoryStateHolder: InventoryStateHolder,
    private val weaponStateHolder: WeaponStateHolder
) : ViewModel() {

    val characterState = characterSheetHolder.state
    val classesState = classStateHolder.state
    val spellsState = spellStateHolder.state
    val inventoryState = inventoryStateHolder.state
    val racesState = raceStateHolder.state
    val weaponsState = weaponStateHolder.state
    val backgroundsState = backgroundStateHolder.state

    fun handleIntent(
        intent: CharacterSheetIntents
    ) {
        when(intent) {

            is CharacterSheetIntents.LoadCharacter -> {
                viewModelScope.launch {
                    characterSheetHolder.loadCharacter(
                        intent.id
                    )
                }
            }

            is CharacterSheetIntents.LoadAllCharacters-> {

            }

            is CharacterSheetIntents.SaveCharacter -> {

            }

            is CharacterSheetIntents.UpdateCharacter -> {

            }

            is CharacterSheetIntents.DeleteCharacter -> {

            }

            is CharacterSheetIntents.LoadClasses -> {

            }

            is CharacterSheetIntents.LoadRaces -> {

            }

            is CharacterSheetIntents.LoadSpells -> {

            }

            is CharacterSheetIntents.LoadBackgrounds -> {

            }

            is CharacterSheetIntents.LoadFeats -> {

            }

            is CharacterSheetIntents.LoadItems -> {

            }

            is CharacterSheetIntents.LoadWeapons -> {

            }
        }
    }
}