package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatureRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.RaceRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class RaceUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val races: List<Race> = emptyList(),
)

@ViewModelScoped
class RaceStateHolder @Inject constructor(
    private val raceRepository: RaceRepository,
) {
    private val _state = MutableStateFlow(RaceUiState())
    val state: StateFlow<RaceUiState> = _state.asStateFlow()

    suspend fun loadAllRaces() {
        val races = raceRepository.getAll()

        _state.value = _state.value.copy(races = races)
    }
}