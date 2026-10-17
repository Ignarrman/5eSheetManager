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
    characterSheetHolder: CharacterSheetStateHolder,
    classStateHolder: ClassStateHolder,
    spellStateHolder: SpellStateHolder,
    inventoryStateHolder: InventoryStateHolder,
    raceStateHolder: RaceStateHolder,
    weaponStateHolder: WeaponStateHolder,
    backgroundStateHolder: BackgroundStateHolder
) : ViewModel() {

    val screenData: StateFlow<CharacterSheetScreenData> =
        combine(
            characterSheetHolder.state,
            classStateHolder.state,
            spellStateHolder.state,
            inventoryStateHolder.state,
            raceStateHolder.state,
            weaponStateHolder.state,
            backgroundStateHolder.state
        ) { character, classes, spells, inventory, races, weapons, backgrounds ->
            CharacterSheetScreenData(
                characterSheet = character,
                classes = classes,
                races = races,
                backgrounds = backgrounds,
                spells = spells,
                inventory = inventory,
                weapons = weapons
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CharacterSheetScreenData(
                characterSheet = characterSheetHolder.state.value.characterSheet,
                classes = classStateHolder.state.value.classes,
                races = raceStateHolder.state.value.races,
                spells = spellStateHolder.state.value.spells,
                backgrounds = backgroundStateHolder.state.value.backgrounds,
                inventory = inventoryStateHolder.state.value.inventory,
                weapons = weaponStateHolder.state.value.weapons
            )
        )
}