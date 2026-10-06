package com.ignarrman.dnd5esheetmanager.data.local.seed.spells

import android.content.Context
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.seed.spells.SpellJsonParser

suspend fun clearSpellsReferenceData(
    database: AppDatabase
) {
    database.spellDao().deleteAll()
}

suspend fun insertSpellsReferenceData(
    database: AppDatabase,
    context: Context
) {
    val spells = SpellJsonParser.parseAll(context)

    database.spellDao().insertAll(spells)
}