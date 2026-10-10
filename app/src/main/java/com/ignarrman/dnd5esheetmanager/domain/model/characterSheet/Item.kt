package com.ignarrman.dnd5esheetmanager.domain.model.characterSheet

data class Item(
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: Int,
    val quantity: Int
)
