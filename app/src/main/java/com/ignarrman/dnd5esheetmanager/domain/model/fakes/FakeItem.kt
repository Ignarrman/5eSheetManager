package com.ignarrman.dnd5esheetmanager.domain.model.fakes

import com.ignarrman.dnd5esheetmanager.domain.model.characterSheet.Item

object FakeItem {

    val rope = Item(
        id = 1L,
        name = "Rope, Hempen (50 feet)",
        description = "A sturdy hempen rope, useful for climbing, securing objects, and exploring.",
        price = 1,
        quantity = 1
    )

    val torch = Item(
        id = 2L,
        name = "Torch",
        description = "A wooden stick wrapped in cloth that burns to provide light.",
        price = 1,
        quantity = 5
    )

    val rations = Item(
        id = 3L,
        name = "Rations (1 day)",
        description = "Travel food consisting of dried and preserved provisions.",
        price = 5,
        quantity = 3
    )

    val healingPotion = Item(
        id = 4L,
        name = "Potion of Healing",
        description = "A magical red liquid that restores hit points when consumed.",
        price = 50,
        quantity = 2
    )

    val backpack = Item(
        id = 5L,
        name = "Backpack",
        description = "A pack for carrying equipment and adventuring supplies.",
        price = 2,
        quantity = 1
    )

    val all = listOf(
        rope,
        torch,
        rations,
        healingPotion,
        backpack
    )
}