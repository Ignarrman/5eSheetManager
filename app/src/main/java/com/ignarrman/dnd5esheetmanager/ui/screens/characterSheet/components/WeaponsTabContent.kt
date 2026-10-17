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
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeWeapons
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun WeaponsTabContent(
    weapons: List<Weapon>,
    proficiencyBonus: Int?,
    onAddWeapon: () -> Unit,
    onProficiencyChange: (Long) -> Unit
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        WeaponsSection(
            modifier = Modifier,
            proficiencyBonus = proficiencyBonus,
            weapons = weapons,
            onAddWeapon = onAddWeapon,
            onProficiencyChange = onProficiencyChange
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WeaponsTabContentPreview() {

    val proficiencyBonus = FakeCharacterSheet.shadowmere.proficiencyBonus
    val weapons = FakeWeapons.all

    _5eSheetManagerTheme(){
        WeaponsTabContent(
            weapons = weapons,
            proficiencyBonus = proficiencyBonus,
            onAddWeapon = {},
            onProficiencyChange = {}
        )
    }
}