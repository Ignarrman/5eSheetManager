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

    private val spellsMap = mutableMapOf<Long, Spell>()
    private val featuresById = mutableMapOf<Long, Feature>()
}