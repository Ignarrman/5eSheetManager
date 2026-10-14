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
import com.ignarrman.dnd5esheetmanager.domain.model.fakes.FakeNotes
import com.ignarrman.dnd5esheetmanager.ui.theme._5eSheetManagerTheme

@Composable
fun NotesTabContent(
    notes: String,
    onNotesChange: (String) -> Unit,
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        NotesSection(
            modifier = Modifier,
            notes = notes,
            onNotesChange = onNotesChange
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotesTabContentPreview() {

    val notes = FakeNotes.notes

    _5eSheetManagerTheme(){
        NotesTabContent(
            notes = notes,
            onNotesChange = {}
        )
    }
}