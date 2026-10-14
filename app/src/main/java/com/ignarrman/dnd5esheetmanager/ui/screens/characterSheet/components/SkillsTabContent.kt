package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun SkillsTabContent(
    stats: Map<AbilityScores, Int>,
    skillProficiencies: List<Skill>,
    skillExpertise: List<Skill>,
    proficiencyBonus: Int?
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SkillTable(
            stats = stats,
            skillProficiencies = skillProficiencies,
            skillExpertise = skillExpertise,
            proficiencyBonus = proficiencyBonus ?: 0
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SkillsTabContentPreview() {
    val characterSheet = FakeCharacterSheet.shadowmere
    val stats = characterSheet.stats
    val skillProficiencies = characterSheet.skillProficiencies
    val skillExpertise = characterSheet.skillExpertise
    val proficiencyBonus = characterSheet.proficiencyBonus

    _5eSheetManagerTheme(){
        SkillsTabContent(
            stats = stats,
            skillProficiencies = skillProficiencies,
            skillExpertise = skillExpertise,
            proficiencyBonus = proficiencyBonus
        )
    }
}