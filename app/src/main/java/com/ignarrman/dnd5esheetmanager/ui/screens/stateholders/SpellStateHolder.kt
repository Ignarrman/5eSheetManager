package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.SpellRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


data class SpellsUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val spells: List<Spell> = emptyList(),
)

@ViewModelScoped
class SpellStateHolder @Inject constructor(
    private val spellRepository: SpellRepository
) {
    private val _state = MutableStateFlow(SpellsUiState())
    val state: StateFlow<SpellsUiState> = _state.asStateFlow()

    suspend fun loadAllSpells() {
        val spells = spellRepository.getAll()

        _state.value = _state.value.copy(spells = spells)
    }

    suspend fun insertSpell(characterId: Long, spell: Spell) {
        spellRepository.insertCharacterSpell(spell, characterId)
    }

    suspend fun deleteSpell(characterId: Long, spellId: Long) {
        spellRepository.deleteCharacterSpell(spellId = spellId, characterId = characterId)
    }
}