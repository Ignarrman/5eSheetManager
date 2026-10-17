package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.BackgroundRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatureRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BackgroundUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val backgrounds: List<Background> = emptyList(),
)

@ViewModelScoped
class BackgroundStateHolder @Inject constructor(
    private val backgroundRepository: BackgroundRepository,
    private val featureRepository: FeatureRepository
) {
    private val _state = MutableStateFlow(BackgroundUiState())
    val state: StateFlow<BackgroundUiState> = _state.asStateFlow()

    private val backgroundsMap = mutableMapOf<Long, Background>()

}