package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.ClassRepository
import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatureRepository
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class ClassUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val classes: List<PlayerClass> = emptyList(),
)

@ViewModelScoped
class ClassStateHolder @Inject constructor(
    private val classRepository: ClassRepository,
    private val featureRepository: FeatureRepository
) {
    private val _state = MutableStateFlow(ClassUiState())
    val state: StateFlow<ClassUiState> = _state.asStateFlow()

    private val classesMap = mutableMapOf<Long, PlayerClass>()
}