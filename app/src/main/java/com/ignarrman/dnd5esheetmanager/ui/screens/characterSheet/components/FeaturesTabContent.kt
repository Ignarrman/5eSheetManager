package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeats
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeFeatures
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.CharacterSheetIntents
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun FeaturesTabContent(
    characterId: Long,
    classFeatures: Map<Int, List<Feature>>,
    raceFeatures: List<Feature>,
    backgroundFeatures: Feature?,
    featList: List<Feat>,
    featCharacter: List<Feat>,
    onAddFeat: (Feat) -> Unit,
    onRemoveFeat: (Long) -> Unit
){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ClassFeatureSection(
            title = "Class Features",
            features = classFeatures
        )

        FeatureSection(
            title = "Race Features",
            features = raceFeatures
        )

        FeatureSection(
            title = "Background Features",
            features = backgroundFeatures?.let { listOf(backgroundFeatures) } ?: emptyList()
        )

        FeatSection(
            feats = featList,
            featsCharacter = featCharacter,
            onAddFeat = onAddFeat,
            onRemoveFeat = onRemoveFeat
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FeaturesTabContentPreview() {

    val fakeClassFeature = FakeFeatures.allClass
    val fakeRaceFeatures = FakeFeatures.allRace
    val fakeBackgroundFeature = FakeFeatures.rusticHospitality
    val fakeFeats = listOf(FakeFeats.alert)

    _5eSheetManagerTheme(){
        FeaturesTabContent(
            classFeatures =fakeClassFeature,
            raceFeatures = fakeRaceFeatures,
            backgroundFeatures = fakeBackgroundFeature,
            featList = fakeFeats,
            featCharacter = fakeFeats.subList(0,1),
            characterId = FakeCharacterSheet.shadowmere.id!!,
            onAddFeat = {_ -> },
            onRemoveFeat = { }
        )
    }
}