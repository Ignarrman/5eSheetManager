package com.ignarrman.dnd5esheetmanager.ui.screens.characterSheet.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ignarrman.dnd5esheetmanager.R
import com.ignarrman.dnd5esheetmanager.domain.model.Feature
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.AbilityScores
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Skill
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Weapon
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.getAttributes
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.getScoreBonus
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.getScoreProficiencyBonus
import com.ignarrman.dnd5esheetmanager.domain.model.feat.Feat
import com.ignarrman.dnd5esheetmanager.domain.model.races.Speed
import com.ignarrman.dnd5esheetmanager.domain.model.spells.Spell
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellComponents
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSchool
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpellSlotProgression
import com.ignarrman.dnd5esheetmanager.domain.model.spells.SpentSpellSlots
import com.ignarrman.dnd5esheetmanager.domain.model.spells.getDifficultyClass

private val FrameColor = Color(0xFF526575)
private val PanelColor = Color(0xFF263440)
private val InnerPanelColor = Color(0xFF1D2A34)
private val TextColor = Color(0xFFF1F4F7)

@Composable
fun ProficiencyIndicator(
    modifier: Modifier = Modifier,
    proficient: Boolean,
    expertise: Boolean = false,
    color: Color = Color(0xFFF1F4F7)
) {
    Box(
        modifier = modifier
            .size(18.dp)
            .then(
                if (expertise) {
                    Modifier.border(
                        width = 1.5.dp,
                        color = color,
                        shape = CircleShape
                    )
                } else {
                    Modifier
                }
            )
            .padding(if (expertise) 3.dp else 2.dp)
            .size(12.dp)
            .clip(CircleShape)
            .background(
                color = if (proficient) color else Color.Transparent,
                shape = CircleShape
            )
            .border(
                width = 1.5.dp,
                color = color,
                shape = CircleShape
            )
    )
}

@Composable
fun AbilityScoreCard(
    score: Int,
    scoreName: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .padding(bottom = 14.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .size(width = 108.dp, height = 120.dp)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(PanelColor)
                .border(
                    width = 2.dp,
                    color = FrameColor,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(
                    horizontal = 6.dp,
                    vertical = 8.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = scoreName.uppercase(),
                color = TextColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(InnerPanelColor)
                    .border(
                        width = 1.dp,
                        color = FrameColor,
                        shape = RoundedCornerShape(5.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "%+d".format(getScoreBonus(score)),
                    color = TextColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-0).dp)
                .width(56.dp)
                .height(28.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF10151B))
                .border(
                    width = 2.dp,
                    color = FrameColor,
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$score",
                color = TextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            AppTextField(
                modifier = modifier,
                value = "$score",
                onValueChange = onValueChange,
                placeholder = "—",
                fontSize = 18.sp,
                addBorder = false,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun SavingThrowCard(
    score: Int,
    scoreName: String,
    proficiency: Boolean,
    proficiencyBonus: Int,
    modifier: Modifier = Modifier
) {
    val frameColor = MaterialTheme.colorScheme.outline
    val panelColor = Color(0xFF263440)
    val innerPanelColor = Color(0xFF1D2A34)
    val textColor = Color(0xFFF1F4F7)

    Row(
        modifier = modifier
            .size(width = 180.dp, height = 50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(panelColor)
            .border(
                width = 1.5.dp,
                color = frameColor,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ProficiencyIndicator(
            proficient = proficiency
        )

        Text(
            text = scoreName.uppercase(),
            modifier = Modifier.weight(1f),
            color = textColor,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )

        Box(
            modifier = Modifier
                .background(
                    color = innerPanelColor,
                    shape = RoundedCornerShape(6.dp)
                )
                .border(
                    width = 1.dp,
                    color = frameColor,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "%+d".format(
                    getScoreProficiencyBonus(
                        score = score,
                        proficiency = proficiency,
                        expertise = false,
                        proficiencyBonus = proficiencyBonus
                    )
                ),
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProficiencyBonusCard(
    modifier: Modifier,
    proficiencyBonus: Int,
    onValueChange: (String) -> Unit
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Proficiency Bonus".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )
        Spacer(modifier = Modifier.size(8.dp))

        AppTextField(
            modifier = Modifier,
            value = "%+d".format(proficiencyBonus),
            placeholder = "Character Name",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            onValueChange = onValueChange
        )

    }
}

@Composable
fun InitiativeCard(
    modifier: Modifier,
    initiative: Int? = null,
    onValueChange: (String) -> Unit
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Initiative".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))

        AppTextField(
            modifier = Modifier,
            value = "%+d".format(initiative),
            onValueChange = onValueChange,
            placeholder = "—",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SpeedCard(
    modifier: Modifier = Modifier,
    speeds: Speed? = null
) {
    val textColor = Color(0xFFF1F4F7)

    val speedEntries = if (speeds != null) {
        listOf(
            "Land" to speeds.land,
            "Swim" to speeds.swim,
            "Climb" to speeds.climb,
            "Fly" to speeds.fly
        ).filter { (_, distance) -> distance != null }
    } else {
        emptyList()
    }

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Speed".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        if (speedEntries.isEmpty()) {
            Text(
                text = "—",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )
        } else {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2,
                maxLines = 2
            ) {
                speedEntries.forEach { speed ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = speed.first,
                            fontSize = 16.sp,
                            color = textColor
                        )

                        Text(
                            text = "${speed.second} ft",
                            fontSize = 20.sp,
                            color = textColor,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun HitPointsCard(
    currentHp: Int,
    maxHp: Int,
    temporaryHp: Int,
    modifier: Modifier = Modifier,
    onCurrentHPChange: (String) -> Unit,
    onMaxHPChange: (String) -> Unit,
    onTHPChange: (String) -> Unit,
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Hit Points".uppercase(),
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppTextField(
                    modifier = Modifier.size(width = 40.dp, height = 35.dp),
                    value = "$currentHp",
                    onValueChange = onCurrentHPChange,
                    placeholder = "—",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "/",
                    fontSize = 24.sp,
                )

                AppTextField(
                    modifier = Modifier.size(width = 40.dp, height = 35.dp),
                    value = "$maxHp",
                    onValueChange = onMaxHPChange,
                    placeholder = "—",
                    fontSize = 24.sp
                )

                Text(
                    text = "HP",
                    fontSize = 20.sp,
                )
            }

            if (temporaryHp > 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(2.dp)

                    ) {
                        Text(
                            text = "+",
                            fontSize = 20.sp,
                        )

                        AppTextField(
                            modifier = Modifier.size(width = 40.dp, height = 35.dp),
                            value = temporaryHp.toString(),
                            onValueChange = onTHPChange,
                            placeholder = "—",
                            fontSize = 24.sp,
                        )

                        Text(
                            text = "THP",
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HitDiceCard(
    modifier: Modifier = Modifier,
    dieType: String?,
    available: Int,
    total: Int,
    onValueChange: (String) -> Unit
) {

    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "Hit Dice".uppercase(),
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            AppTextField(
                modifier = Modifier.size(width = 40.dp, height = 35.dp),
                value = "$available",
                onValueChange = onValueChange,
                placeholder = "—",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "/ ${total}d${dieType ?: "(No_dice)"}",
                color = textColor,
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun DeathSavesCard(
    modifier: Modifier,
    successDeathSaves: Int,
    failureDeathSaves: Int,
    onSetToOneSuccess: () -> Unit,
    onSetToTwoSuccess: () -> Unit,
    onSetToThreeSuccess: () -> Unit,
    onSetToOneFailed: () -> Unit,
    onSetToTwoFailed: () -> Unit,
    onSetToThreeFailed: () -> Unit
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "Death Saves".uppercase(),
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Column() {

            val empty = R.drawable.death_saves_tracker_empty
            val filled = R.drawable.death_saves_tracker_checked

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .clickable() { onSetToOneSuccess() }
                        .size(32.dp),
                    painter = painterResource(if(successDeathSaves >= 1) filled else empty),
                    contentDescription = "",
                )

                Icon(
                    modifier = Modifier
                        .clickable() { onSetToTwoSuccess() }
                        .size(32.dp),
                    painter = painterResource(if(successDeathSaves >= 2) filled else empty),
                    contentDescription = "",
                )

                Icon(
                    modifier = Modifier
                        .clickable() { onSetToThreeSuccess() }
                        .size(32.dp),
                    painter = painterResource(if(successDeathSaves >= 3) filled else empty),
                    contentDescription = "",
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .clickable() { onSetToOneFailed() }
                        .size(32.dp),
                    painter = painterResource(if(failureDeathSaves >= 1) filled else empty),
                    contentDescription = "",
                )

                Icon(
                    modifier = Modifier
                        .clickable() { onSetToTwoFailed() }
                        .size(32.dp),
                    painter = painterResource(if(failureDeathSaves >= 2) filled else empty),
                    contentDescription = "",
                )

                Icon(
                    modifier = Modifier
                        .clickable() { onSetToThreeFailed() }
                        .size(32.dp),
                    painter = painterResource(if(failureDeathSaves >= 3) filled else empty),
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
fun PassivePerceptionCard(
    modifier: Modifier,
    perceptionScore: Int
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Passive Perception".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "$perceptionScore",
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ArmorClassCard(
    modifier: Modifier,
    armorClass: Int?,
    onValueChange: (String) -> Unit
){
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Armor Class".uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(8.dp))

        AppTextField(
            modifier = Modifier,
            value = "$armorClass",
            onValueChange = onValueChange,
            placeholder = "—",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ClassFeatureDropdown(
    modifier: Modifier = Modifier,
    level: Int,
    feature: Feature,
    initiallyExpanded: Boolean = false
) {
    var expanded by remember (feature.id, feature.name) {
        mutableStateOf(initiallyExpanded)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatureDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Lv: $level",
                modifier = Modifier.weight(0.2f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = feature.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feature description"
                } else {
                    "Expand feature description"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = feature.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ClassFeatureSection(
    title: String,
    features: Map<Int, List<Feature>>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        features.forEach { featureEntry ->
            featureEntry.value.forEach { featureInLevel ->
                ClassFeatureDropdown(
                    level = featureEntry.key,
                    feature = featureInLevel
                )
            }
        }
    }
}

@Composable
fun FeatureDropdown(
    modifier: Modifier = Modifier,
    feature: Feature,
    initiallyExpanded: Boolean = false
) {
    var expanded by remember (feature.id, feature.name) {
        mutableStateOf(initiallyExpanded)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatureDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = feature.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feature description"
                } else {
                    "Expand feature description"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = feature.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun FeatureSection(
    title: String,
    features: List<Feature>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        features.forEach { feature ->
            FeatureDropdown(
                feature = feature
            )
        }
    }
}

@Composable
fun FeatDropdown(
    feat: Feat,
    modifier: Modifier = Modifier,
    initiallyExpanded: Boolean = false
) {
    var expanded by remember(feat.id, feat.name) {
        mutableStateOf(initiallyExpanded)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = feat.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feat details"
                } else {
                    "Expand feat details"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FeatDetail(
                    label = "Description",
                    value = feat.description
                )

                FeatDetail(
                    label = "Prerequisite",
                    value = feat.prerequisite
                )

                FeatDetail(
                    label = "Ability Bonus",
                    value = feat.abilityBonus
                )
            }
        }
    }
}

@Composable
private fun FeatDetail(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value.ifBlank { "None" },
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FeatSection(
    feats: List<Feat>,
    modifier: Modifier = Modifier,
    title: String = "Feats"
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        feats.forEach { feat ->
            FeatDropdown(
                feat = feat
            )
        }
    }
}

@Composable
fun WeaponsSection(
    modifier: Modifier,
    weapons: List<Weapon>,
    proficiencyBonus: Int?,
    title: String = "Weapons",
    onProficiencyChange: (Long) -> Unit,
    onAddWeapon: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.weight(1f))

            AddButton(modifier = Modifier, onAdd = onAddWeapon)
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        weapons.forEach { weapon ->
            WeaponDropdown(
                modifier = Modifier,
                weapon = weapon,
                proficiencyBonus = proficiencyBonus ?: 0,
                onProficiencyChange = onProficiencyChange
            )
        }
    }
}

@Composable
fun WeaponDropdown(
    modifier: Modifier,
    weapon: Weapon,
    proficiencyBonus: Int,
    onProficiencyChange: (Long) -> Unit
) {
    var expanded by remember (weapon.id) {
        mutableStateOf(false)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "FeatureDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProficiencyIndicator(
                modifier = Modifier.clickable(onClick = { onProficiencyChange(weapon.id!!) }),
                proficient = weapon.proficient
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = weapon.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            val finalAttackBonus = if (weapon.proficient) weapon.attackBonus + proficiencyBonus else weapon.attackBonus

            Text(
                text = "+${finalAttackBonus}",
                modifier = Modifier.weight(0.4f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = weapon.damage + " + ${weapon.damageBonus}",
                modifier = Modifier.weight(0.4f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse feature description"
                } else {
                    "Expand feature description"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "Tags: ${weapon.getAttributes()}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Damage Type: ${weapon.damageType.displayName}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                if (weapon.normalRange != null && weapon.longRange != null){
                    Text(
                        text = "Range: ${weapon.normalRange}/${weapon.longRange}",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Text(
                    text = "Quantity: ${weapon.quantity}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Price: ${weapon.price}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = weapon.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ItemsSection(
    modifier: Modifier,
    inventory: List<Item>,
    title: String = "Items",
    onAddItem: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.weight(1f))

            AddButton(modifier = Modifier, onAdd = onAddItem)
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        inventory.forEach { item ->
            ItemDropdown(
                modifier = Modifier,
                item = item
            )
        }
    }
}

@Composable
fun ItemDropdown(
    modifier: Modifier = Modifier,
    item: Item
) {
    var expanded by remember(item.id) {
        mutableStateOf(false)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "ItemDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "x${item.quantity}",
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse item description"
                } else {
                    "Expand item description"
                },
                modifier = Modifier.rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Price: ${item.price} gp",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = item.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun SkillTable(
    modifier: Modifier = Modifier,
    stats: Map<AbilityScores, Int>,
    skillProficiencies: List<Skill>,
    skillExpertise: List<Skill>,
    proficiencyBonus: Int
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Skill.entries.forEachIndexed { index, skill ->
            val proficient = skill in skillProficiencies || skill in skillExpertise

            val expertise = skill in skillExpertise

            val abilityScore = stats[skill.stat] ?: 10
            val abilityModifier = getScoreProficiencyBonus(
                score = abilityScore,
                proficiency = proficient,
                expertise = expertise,
                proficiencyBonus = proficiencyBonus
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProficiencyIndicator(
                    proficient = proficient,
                    expertise = expertise,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = skill.skillName,
                    modifier = Modifier.weight(1f),
                    color = textColor,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "%+d".format(abilityModifier),
                    color = textColor,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            if (index < Skill.entries.lastIndex) {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline.copy(
                        alpha = 0.35f
                    ),
                    thickness = 0.5.dp
                )
            }
        }
    }
}

@Composable
fun SpellcastingStats(
    modifier: Modifier = Modifier,
    castingScore: AbilityScores,
    castingScoreValue: Int,
    proficiencyBonus: Int
) {
    val textColor = Color(0xFFF1F4F7)

    val scoreModifier = getScoreBonus(castingScoreValue)

    val spellSaveDc = getDifficultyClass(
        proficiencyBonus = proficiencyBonus,
        scoreBonus = scoreModifier
    )

    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Spellcasting",
            style = MaterialTheme.typography.titleLarge,
            color = textColor
        )

        Row(
            modifier = Modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Ability",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = castingScore.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }

            Column {
                Text(
                    text = "Score",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = "%+d".format(scoreModifier),
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }

            Column {
                Text(
                    text = "Save DC",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = spellSaveDc.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
            }
        }
    }
}


@Composable
fun SpellSlotsSection(
    progression: SpellSlotProgression?,
    spentSpellSlots: SpentSpellSlots?,
    onSpentSpellSlotsChange: (SpentSpellSlots) -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Spell Slots",
            style = MaterialTheme.typography.titleLarge,
            color = textColor
        )

        when {
            progression == null -> {
                Text(
                    text = "No class selected",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            progression.slots.isEmpty() -> {
                Text(
                    text = "No spellcasting",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            spentSpellSlots == null -> {
                Text(
                    text = "Spell slots not initialized",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            else -> {
                progression.slots
                    .toSortedMap()
                    .forEach { (slotLevel, count) ->
                        SpellSlotRow(
                            slotLevel = slotLevel,
                            totalSlots = count.coerceAtLeast(0),
                            spentSlots = spentSpellSlots.slots[slotLevel] ?: 0,
                            onSpentSlotsChange = { newSpent ->
                                val updated = spentSpellSlots.slots.toMutableMap()

                                if (newSpent == 0) {
                                    updated.remove(slotLevel)
                                } else {
                                    updated[slotLevel] = newSpent
                                }

                                onSpentSpellSlotsChange(
                                    SpentSpellSlots(updated)
                                )
                            }
                        )
                    }
            }
        }
    }
}

@Composable
private fun SpellSlotRow(
    slotLevel: Int,
    totalSlots: Int,
    spentSlots: Int,
    onSpentSlotsChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = Color(0xFFF1F4F7)
    val actionColor = MaterialTheme.colorScheme.primary
    val shape = RoundedCornerShape(5.dp)

    val total = totalSlots.coerceAtLeast(0)
    val spent = spentSlots.coerceIn(0, total)

    val spendIndex = total - spent - 1
    val recoverIndex = total - spent

    Row(
        modifier = modifier.padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Level $slotLevel",
            modifier = Modifier.weight(1f),
            color = textColor,
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(total) { index ->
                val isSpent = index >= total - spent
                val canSpend = index == spendIndex && spent < total
                val canRecover = index == recoverIndex && spent > 0
                val canClick = canSpend || canRecover

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = if (isSpent) {
                                textColor.copy(alpha = 0.35f)
                            } else {
                                textColor
                            },
                            shape = shape
                        )
                        .border(
                            width = if (canClick) 2.dp else 1.dp,
                            color = if (canClick) actionColor else textColor,
                            shape = shape
                        )
                        .clickable(enabled = canClick) {
                            when {
                                canSpend -> onSpentSlotsChange(spent + 1)
                                canRecover -> onSpentSlotsChange(spent - 1)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (canRecover) {
                        Text(
                            text = "+",
                            color = actionColor,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SpellSection(
    modifier: Modifier,
    spells: List<Spell>,
    title: String = "Spells",
    onAddSpell: (Long) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.weight(1f))

            AddButton(modifier = Modifier,
                onAdd = {
                    // TODO This function opens the dialog, the add spells will come on the dialog
                }
            )
        }

        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )
        val sortedSpells = spells.sortedWith(
            compareBy<Spell> { it.level }
                .thenBy { it.name.lowercase() }
        )
        sortedSpells.forEach { spell ->
            SpellDropdown(
                modifier = Modifier,
                spell = spell
            )
        }
    }
}

@Composable
fun SpellDropdown(
    modifier: Modifier = Modifier,
    spell: Spell
) {
    var expanded by remember(spell.id) {
        mutableStateOf(false)
    }

    val textColor = Color(0xFFF1F4F7)

    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 220),
        label = "SpellDropdownArrowRotation"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { expanded = !expanded }
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${spell.level}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Icon(
                painter = painterResource(getSchoolIcon(spell.school) as Int),
                contentDescription = spell.school.schoolName,
                tint = textColor,
                modifier = Modifier.size(22.dp)
            )

            Text(
                text = spell.name,
                modifier = Modifier.weight(1f),
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            if (spell.ritual) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = "Ritual",
                    tint = textColor,
                    modifier = Modifier.size(18.dp)
                )
            }

            if (spell.concentration) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = "Concentration",
                    tint = textColor,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = "(${spell.components.toAbbreviation()})",
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = spell.castingTime.toCastingTimeAbbreviation(),
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    "Collapse spell details"
                } else {
                    "Expand spell details"
                },
                modifier = Modifier
                    .size(24.dp)
                    .rotate(arrowRotation),
                tint = textColor
            )
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 220)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 180)
            )
        ) {
            Column {
                Spacer(modifier = Modifier.padding(top = 12.dp))

                DetailRow(
                    label = "Level",
                    value = if (spell.level == 0) {
                        "Cantrip"
                    } else {
                        "${spell.level}"
                    }
                )

                DetailRow(
                    label = "School",
                    value = spell.school.schoolName,
                )

                DetailRow(
                    label = "Components",
                    value = spell.components.toFullDescription()
                )

                DetailRow(
                    label = "Range",
                    value = spell.range
                )

                DetailRow(
                    label = "Casting Time",
                    value = spell.castingTime
                )

                DetailRow(
                    label = "Ritual",
                    value = if (spell.ritual) "Yes" else "No"
                )

                DetailRow(
                    label = "Concentration",
                    value = if (spell.concentration) "Yes" else "No"
                )

                DetailRow(
                    label = "Duration",
                    value = spell.duration
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))

                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.padding(top = 12.dp))

                Text(
                    text = spell.description,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.padding(top = 12.dp))

                Text(
                    text = "Source: ${spell.source}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String,
    icon: (@Composable () -> Unit)? = null
) {
    val textColor = Color(0xFFF1F4F7)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            icon()
            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = "$label:",
            modifier = Modifier.weight(0.42f),
            color = textColor,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = value,
            modifier = Modifier.weight(0.58f),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

private fun SpellComponents
        .toAbbreviation(): String = buildList {
    if (verbal) add("V")
    if (somatic) add("S")
    if (material != null) add("M")
}.joinToString(",").ifEmpty { "—" }

private fun SpellComponents
        .toFullDescription(): String = buildList {
    if (verbal) add("V (Verbal)")
    if (somatic) add("S (Somatic)")
    if (material != null) add("M (Material: $material)")
}.joinToString(", ").ifEmpty { "None" }

private fun String.toCastingTimeAbbreviation(): String {
    val normalized = trim().lowercase()

    return when {
        normalized == "action" -> "A"
        normalized == "bonus action" -> "B"
        normalized == "reaction" -> "R"
        normalized.startsWith("1 action") -> "A"
        normalized.startsWith("1 bonus action") -> "BA"
        normalized.startsWith("1 reaction") -> "R"
        else -> this
    }
}

private fun getSchoolIcon(school: SpellSchool) =
    when (school) {
        SpellSchool.ABJURATION -> R.drawable.school_badge_shield
        SpellSchool.CONJURATION -> R.drawable.school_badge_conjuration
        SpellSchool.DIVINATION -> R.drawable.school_badge_divination
        SpellSchool.ENCHANTMENT -> R.drawable.school_badge_enchantment
        SpellSchool.EVOCATION -> R.drawable.school_badge_evocation
        SpellSchool.ILLUSION -> R.drawable.school_badge_illusion
        SpellSchool.NECROMANCY -> R.drawable.school_badge_necromancy
        SpellSchool.TRANSMUTATION -> R.drawable.school_badge_transmutation
    }


@Composable
fun NotesSection(
    modifier: Modifier = Modifier,
    notes: String,
    onNotesChange: (String) -> Unit,
    title: String = "Notes"
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = notes,
            onValueChange = onNotesChange,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 160.dp),
            placeholder = {
                Text(
                    text = "Write your notes here...",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            minLines = 5,
            maxLines = Int.MAX_VALUE,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFFF1F4F7)
            ),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFFF1F4F7),
                unfocusedTextColor = Color(0xFFF1F4F7),
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedBorderColor = MaterialTheme.colorScheme.outline,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                cursorColor = Color(0xFFF1F4F7),
                focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
    }
}

@Composable
fun AddButton(
    modifier: Modifier,
    onAdd: () -> Unit
) {
    Button(
        modifier = modifier.size(35.dp),
        onClick = onAdd,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFF1F4F7)
        ),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = Color(0xFFF1F4F7)
        )
    ) {
        Text(
            text = "+",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Center,
    textColor: Color = Color(0xFFF1F4F7),
    backgroundColor: Color = InnerPanelColor,
    addBorder: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true
) {
    BasicTextField(
        modifier = Modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        textStyle = TextStyle(
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign
        ),
        keyboardOptions = keyboardOptions,
        cursorBrush = SolidColor(textColor),
        decorationBox = { innerTextField ->

            Box(
                modifier = modifier
                    .background(backgroundColor)
                    .border(
                        width = 1.dp,
                        color = if (addBorder) textColor else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .size(width = 60.dp, height = 45.dp),
                contentAlignment = Alignment.Center
            ) {
                if (value.isEmpty() && placeholder.isNotEmpty()) {
                    Text(
                        text = placeholder,
                        color = textColor.copy(alpha = 0.5f),
                        fontSize = fontSize,
                        fontWeight = fontWeight,
                    )
                }

                innerTextField()
            }
        }
    )
}

@Composable
fun ProfileBox(
    characterName: String,
    raceName: String,
    backgroundName: String,
    className: String,

    races: List<String>,
    classes: List<String>,
    backgrounds: List<String>,

    onNameChange: (String) -> Unit,
    onRaceChange: (String) -> Unit,
    onClassChange: (String) -> Unit,
    onBackgroundChange: (String) -> Unit,
) {
    val textColor = Color(0xFFF1F4F7)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = characterName,
            onValueChange = onNameChange,
            label = { Text("Character Name") }
        )
        AutocompleteOutlinedTextField(
            value = raceName,
            onValueChange = onRaceChange,
            options = races,
            label = "Race"
        )
        AutocompleteOutlinedTextField(
            value = backgroundName,
            onValueChange = onClassChange,
            options = backgrounds,
            label = "Background"
        )
        AutocompleteOutlinedTextField(
            value = className,
            onValueChange = onBackgroundChange,
            options = classes,
            label = "Cleric"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutocompleteOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    options: List<String>,
    label: String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val filteredOptions = remember(value, options) {
        if (value.isBlank()) {
            options
        } else {
            options.filter {
                it.contains(value, ignoreCase = true)
            }
        }
    }

    ExposedDropdownMenuBox(
        expanded = expanded && filteredOptions.isNotEmpty(),
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                expanded = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            label = {
                Text(label)
            },
            singleLine = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            }
        )

        ExposedDropdownMenu(
            expanded = expanded && filteredOptions.isNotEmpty(),
            onDismissRequest = {
                expanded = false
            }
        ) {
            filteredOptions.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(option)
                    },
                    onClick = {
                        onValueChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ProfileLevelBox(
    level: Int,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
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
        Box(Modifier.offset(x = (-50).dp)) {
            Box(
                modifier = Modifier
                    .size(80.dp)
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
                AppTextField(
                    modifier = Modifier.size(width = 40.dp, height = 35.dp),
                    value = "$level",
                    onValueChange = onValueChange,
                    placeholder = "—",
                    fontSize = 32.sp,
                    addBorder = false,
                    backgroundColor = Color.Transparent,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}