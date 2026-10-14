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
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeSpells
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun SpellsTabContent(
    characterSpells: List<Spell> = emptyList(),
    proficiencyBonus: Int? = null,
    castingScore: AbilityScores,
    castingScoreValue: Int,
    spellSlots: SpellSlotProgression? = null,
){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SpellcastingStats(
            modifier = Modifier,
            castingScore = castingScore,
            castingScoreValue = castingScoreValue,
            proficiencyBonus = proficiencyBonus ?: 0
        )
        SpellSlotsSection(
            modifier = Modifier,
            progression = spellSlots?: SpellSlotProgression(emptyMap())
        )
        SpellSection(
            modifier = Modifier,
            spells = characterSpells
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SpellsTabContentPreview() {

    val spells = FakeSpells.all
    val castingScore = FakePlayerClass.wizard.spellcasting.spellcastingAbility
    val castingScoreValue = FakeCharacterSheet.shadowmere.stats[AbilityScores.INT]!!
    val spellSlots = FakePlayerClass.wizard.spellcasting.spellSlotProgression[5]
    val proficiencyBonus = FakeCharacterSheet.shadowmere.proficiencyBonus

    _5eSheetManagerTheme(){
        SpellsTabContent(
            characterSpells = spells,
            castingScore = castingScore,
            castingScoreValue = castingScoreValue,
            spellSlots = spellSlots,
            proficiencyBonus = proficiencyBonus
        )
    }
}