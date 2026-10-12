package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.ignarrman.dnd5esheetmanager.R
import com.ignarrman.dnd5esheetmanager.domain.model.backgrounds.Background
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.classes.PlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeBackground
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakePlayerClass
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeRace
import com.ignarrman.dnd5esheetmanager.domain.model.races.Race
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun GeneralTabContent(
    characterSheet: CharacterSheet,
    race: Race?,
    background: Background?,
    playerClass: PlayerClass?
) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(shape = CircleShape)
                        .background(Color.LightGray)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = CircleShape
                        ),
                    painter = painterResource(R.drawable.dnd_logo),
                    contentDescription = null,
                )
                Box(Modifier.offset(x = (-40).dp)) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                shape = CircleShape
                            )
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.outline,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = characterSheet.level.toString(),
                            fontSize = 24.sp,
                            color = Color(0xFFF1F4F7)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {

                    Text(characterSheet.name, color = Color(0xFFF1F4F7))
                    Text(race?.name ?: "No Race", color = Color(0xFFF1F4F7))
                    Text(background?.name ?: "No background", color = Color(0xFFF1F4F7))
                    Text(playerClass?.name ?: "No color", color = Color(0xFFF1F4F7))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                ProficiencyBonusCard(
                    modifier = Modifier
                        .weight(0.4f)
                        .size(height = 100.dp, width = 120.dp)
                        ,
                    proficiencyBonus = characterSheet.proficiencyBonus
                )
                ArmorClassCard(
                    modifier = Modifier.size(height = 100.dp, width = 90.dp),
                    armorClass = characterSheet.armorClass
                )

                InitiativeCard(
                    modifier = Modifier.size(height = 100.dp, width = 100.dp),
                    initiative = characterSheet.proficiencyBonus
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                SpeedCard(
                    modifier = Modifier.width(200.dp),
                    speeds = race?.speed
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 3,
                maxLines = 2
            ) {
                AbilityScores.entries.forEach { it ->
                    AbilityScoreCard(
                        score = characterSheet.stats[it] ?: 10,
                        scoreName = it.statName
                    )
                }
            }

            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2,
                maxLines = 3
            ) {
                AbilityScores.entries.forEach { it ->
                    SavingThrowCard(
                        score = characterSheet.stats[it] ?: 10,
                        scoreName = it.statName,
                        proficiency = characterSheet.savingThrowProficiencies.contains(it),
                        proficiencyBonus = 2
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            HitPointsCard(
                modifier = Modifier,
                currentHp = characterSheet.currentHp ?: 0,
                maxHp = characterSheet.maxHp ?: 0,
                temporaryHp = characterSheet.temporaryHp,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HitDiceCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    dieType = playerClass?.hitDice.toString(),
                    available = characterSheet.currentHitDice,
                    total = characterSheet.level
                )
                PassivePerceptionCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    perceptionScore = characterSheet.skills[Skill.PERCEPTION] ?: 0
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            DeathSavesCard(
                modifier = Modifier.fillMaxWidth(),
                successDeathSaves = characterSheet.deathSaveSuccesses,
                failureDeathSaves = characterSheet.deathSaveFailures
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GeneralTabContentPreview() {

    val character = FakeCharacterSheet.thorin
    val race = FakeRace.dragonborn
    val background = FakeBackground.noble
    val playerClass = FakePlayerClass.fighter

    _5eSheetManagerTheme() {
        GeneralTabContent(
            characterSheet = character,
            race = race,
            background = background,
            playerClass = playerClass
        )
    }
}