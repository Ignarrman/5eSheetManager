package com.ignarrman.dnd5esheetmanager.data.local.seed.charactersheet

import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.mappers.toEntity
import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.ProficiencyBonusProgression


fun getProgression(): List<ProficiencyBonusProgression> {
    return listOf(
        ProficiencyBonusProgression(1, 2),
        ProficiencyBonusProgression(2, 2),
        ProficiencyBonusProgression(3, 2),
        ProficiencyBonusProgression(4, 2),
        ProficiencyBonusProgression(5, 3),
        ProficiencyBonusProgression(6, 3),
        ProficiencyBonusProgression(7, 3),
        ProficiencyBonusProgression(8, 3),
        ProficiencyBonusProgression(9, 4),
        ProficiencyBonusProgression(10, 4),
        ProficiencyBonusProgression(11, 4),
        ProficiencyBonusProgression(12, 4),
        ProficiencyBonusProgression(13, 5),
        ProficiencyBonusProgression(14, 5),
        ProficiencyBonusProgression(15, 5),
        ProficiencyBonusProgression(16, 5),
        ProficiencyBonusProgression(17, 6),
        ProficiencyBonusProgression(18, 6),
        ProficiencyBonusProgression(19, 6),
        ProficiencyBonusProgression(20, 6)
    )
}

suspend fun insertProficiencyBonusProgressionReferenceData(
    database: AppDatabase
) {
    database.proficiencyBonusDao().insertAll(getProgression().map { it.toEntity() })
}