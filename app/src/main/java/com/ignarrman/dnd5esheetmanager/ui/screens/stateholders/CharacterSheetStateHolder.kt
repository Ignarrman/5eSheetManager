package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.BackgroundRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.CharacterSheetRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.ClassRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatureRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.ItemRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.RaceRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.SpellRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.WeaponRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class CharacterSheetUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val characterSheet: CharacterSheet = CharacterSheet.Empty,
)

@ViewModelScoped
class CharacterSheetStateHolder @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository
) {

    private val _state = MutableStateFlow(
        CharacterSheetUiState()
    )

    val state = _state.asStateFlow()

    suspend fun loadCharacter(
        characterId: Long?
    ) {

        if (characterId == null) {
            _state.value = CharacterSheetUiState(
                characterSheet = CharacterSheet.Empty
            )
            return
        }

        val character = characterSheetRepository.getCharacterById(characterId)

        _state.value = _state.value.copy(
            characterSheet = character ?: CharacterSheet.Empty
        )
    }
}