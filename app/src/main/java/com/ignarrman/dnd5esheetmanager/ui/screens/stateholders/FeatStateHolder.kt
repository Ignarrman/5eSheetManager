package com.ignarrman.dnd5esheetmanager.ui.screens.stateholders

import com.ignarrman.dnd5esheetmanager.data.local.repositories.FeatRepository
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class FeatUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val feats: List<Feat> = emptyList()
)

@ViewModelScoped
class FeatStateHolder @Inject constructor(
    private val featRepository: FeatRepository
){
    private val _state = MutableStateFlow(FeatUiState())
    val state = _state.asStateFlow()

    suspend fun loadAllFeats() {
        val feats = featRepository.getAll()

        _state.value = _state.value.copy(feats = feats)
    }

    suspend fun insertFeat(characterId: Long, feat: Feat) {
        featRepository.insert(feat, characterId)
        loadAllFeats()
    }

    suspend fun deleteFeat(characterId: Long, featId: Long) {
        featRepository.deleteFeat(characterId, featId)
        loadAllFeats()
    }

}