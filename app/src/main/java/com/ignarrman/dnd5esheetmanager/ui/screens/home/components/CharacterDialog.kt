package com.ignarrman.dnd5esheetmanager.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.CharacterSheet
import com.ignarrman.dnd5esheetmanager.domain.model.classes.getClassName
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeCharacterSheet
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDialog(
    savedCharacters: List<CharacterSheet>,
    onDismiss: () -> Unit,
    onLoadClick: (Long) -> Unit
) {
    val selectedCharacter = remember { mutableStateOf<Long?>(null) }


    BasicAlertDialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.DarkGray)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Select a Character",
                        color = Color.White
                    )
                }
                HorizontalDivider(
                    color = Color.Black,
                    thickness = 2.dp
                )
                if (savedCharacters.isEmpty()){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay personajes creados aún",
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        state = rememberLazyListState()
                    ) {
                        items(
                            items = savedCharacters,
                            key = { it.id ?: it.name }
                        ) { character ->
                            val selected = selectedCharacter.value == character.id

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        if (selected) Color.LightGray else Color.Transparent
                                    )
                                    .clickable {
                                        selectedCharacter.value = character.id
                                    }
                                    .padding(12.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = character.name,
                                    modifier = Modifier.weight(1f),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = getClassName(character.playerClassId),
                                    modifier = Modifier.weight(0.6f),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = "Level ${character.level}",
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier.height(8.dp),
                    color = Color.Black,
                    thickness = 2.dp
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    shape = RoundedCornerShape(size = 8.dp),
                    enabled = selectedCharacter.value != null,
                    onClick = { onLoadClick(selectedCharacter.value!!) }
                ) {
                    Text(
                        text = "Load",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterDialogPreview() {
    _5eSheetManagerTheme() {
        CharacterDialog(
            savedCharacters = FakeCharacterSheet.all,
            onDismiss = {},
            onLoadClick = {}
        )
    }
}