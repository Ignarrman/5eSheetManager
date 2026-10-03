package com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reference_data_metadata")
data class ReferenceDataMetadataEntity(
    @PrimaryKey
    val key: String,
    val version: Int
)