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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class CharacterSheetUiState(
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val errorMessage: String? = null,
    val hasUnsavedChanges: Boolean = false,

    val characterSheet: CharacterSheet,
    val races: List<Race> = emptyList(),
    val backgrounds: List<Background> = emptyList(),
    val classes: List<PlayerClass> = emptyList(),
    val feats: List<Feat> = emptyList(),
    val spells: List<Spell> = emptyList(),

    val classFeatures: List<Feature> = emptyList(),
    val raceFeatures: List<Feature> = emptyList(),
    val backgroundFeature: Feature? = null,

    val weapons: List<Weapon> = emptyList(),
    val inventory: List<Item> = emptyList(),
)

@HiltViewModel
class CharacterSheetViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository,
    private val referenceDataLoader: ReferenceDataLoader
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterSheetUiState(isLoading = true, characterSheet = CharacterSheet.Empty))
    val state: StateFlow<CharacterSheetUiState> = _state.asStateFlow()


    fun loadCharacter(characterId: Long?) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                val character = if (characterId != null) {
                    characterSheetRepository.getCharacterById(characterId)
                } else {
                    CharacterSheet.Empty
                }

                if (characterId != null && character == null) {
                    _state.update { it.copy(isLoading = false, errorMessage = "No se encontró el personaje.") }
                    return@launch
                }

                _state.update { it.copy(isLoading = false, characterSheet = character ?: CharacterSheet.Empty, errorMessage = null)
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, errorMessage = e.message ?: "Error al cargar la ficha.") }
            }
        }
    }

    fun getRaceFeatures(featureIds: List<Long>) {
        viewModelScope.launch {
            try {
                val features = referenceDataLoader.getFeatures(featureIds)

                _state.update { it.copy(raceFeatures = features) }

            } catch (e: Exception) {
                _state.update { it.copy(errorMessage = e.message ?: "Error al cargar las características.") }
            }
        }
    }

    fun getFeature(featureId: Long) {
        viewModelScope.launch {
            try {
                val feature = referenceDataLoader.getFeature(featureId)

                _state.update { it.copy(backgroundFeature = feature) }

            } catch (e: Exception) {
                _state.update { it.copy(errorMessage = e.message ?: "Error al cargar la característica.") }
            }
        }
    }
}