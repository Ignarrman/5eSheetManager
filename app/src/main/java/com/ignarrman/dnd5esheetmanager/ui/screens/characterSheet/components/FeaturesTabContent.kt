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
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun FeaturesTabContent(
    classFeatures: List<Feature>,
    raceFeatures: List<Feature>,
    backgroundFeatures: List<Feature>,
    featList: List<Feat>
){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        FeatureSection(
            title = "Class Features",
            features = classFeatures
        )

        FeatureSection(
            title = "Race Features",
            features = raceFeatures
        )

        FeatureSection(
            title = "Background Features",
            features = backgroundFeatures
        )

        FeatSection(
            feats = featList
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FeaturesTabContentPreview() {

    _5eSheetManagerTheme(){
        FeaturesTabContent(

        )
    }
}