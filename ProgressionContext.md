# 5eSheetManager - Project Context

## Project Overview

5eSheetManager is an Android application designed to replace physical Dungeons & Dragons 5e (2014) character sheets.

The objective is **not** to implement the full D&D rules engine.

The objective **is** to provide a digital character sheet that:

- Works completely offline.
- Stores all characters locally.
- Includes D&D reference data locally through Room.
- Helps players track character information during sessions.
- Eliminates common tabletop problems:
    - Forgotten character sheets.
    - Illegible sheets due to erasing and rewriting.
    - Lack of space on paper sheets.
    - Difficulty tracking resources during play.

The intended experience should feel similar to using a paper character sheet, but digitally.

---

## Technology Stack

- Kotlin
- Jetpack Compose
- Room
- Coroutines
- Flow
- MVI
- Clean Architecture

---

## Architecture Philosophy

### Domain Layer

The domain layer should represent game concepts independently of persistence.

Examples:

```kotlin
Feature
PlayerClass
Barbarian
Bard
Character
Spell
Item
```

Domain models should not contain Room-specific concerns.

IDs are not required unless they represent a meaningful concept in the domain itself.

Example:

```kotlin
data class Feature(
    val name: String,
    val description: String
)
```

Features are currently treated as Value Objects.

---

### Data Layer

The data layer contains:

```text
Entities
DAOs
Repositories
Mappers
```

Room entities may contain:

- Primary keys
- Foreign keys
- Junction tables
- Any persistence-specific information

Example:

```kotlin
@Entity
data class FeatureEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String
)
```

Entity-to-domain mapping should be handled through mappers.

---

## Current Class Model

### Feature

```kotlin
data class Feature(
    val name: String,
    val description: String,
)
```

---

### Barbarian

```kotlin
data class Barbarian(
    override val name: String = "Barbarian",
    override val hitDice: Int = 12,
    override val features: Map<Int, List<Feature>>,
    val rage: Map<Int, RageProgression>
) : PlayerClass(name, hitDice, features)
```

```kotlin
data class RageProgression(
    val charges: Int,
    val damageBonus: Int
)
```

---

### Bard

```kotlin
data class Bard(
    override val name: String = "Bard",
    override val hitDice: Int = 8,
    override val features: Map<Int, List<Feature>>,
    val bardicInspiration: Map<Int, BardicInspirationProgression>
) : PlayerClass(name, hitDice, features)
```

```kotlin
data class BardicInspirationProgression(
    val die: Int
)
```

---

## Important Decision: Features Per Level

The model was updated from:

```kotlin
Map<Int, Feature>
```

to:

```kotlin
Map<Int, List<Feature>>
```

Reason:

Some classes gain multiple features at the same level.

Example:

### Barbarian Level 1

- Rage
- Unarmored Defense

### Barbarian Level 2

- Reckless Attack
- Danger Sense

Using a list correctly represents the rules.

---

## Feature Design Philosophy

All features are intentionally represented by the same model:

```kotlin
Feature(
    name,
    description
)
```

This includes:

- Class Features
- Racial Features
- Subclass Features
- Feat Features

The project intentionally avoids creating multiple feature types unless a strong need appears.

Reason:

The application aims to remain simple and maintainable.

Most features are displayed as information for the player rather than executed as automatic game mechanics.

---

## D&D Rules Scope

The application is **not** intended to become a complete rules engine.

Many rules should remain the player's responsibility.

Examples:

- Natural Armor
- Complex AC calculations
- Feature interactions
- Niche edge cases
- Automatic rules resolution
- Complete multiclass spellcasting calculations

The player can manually update values, just as they would on paper.

---

## Resources To Support

Resource tracking is considered valuable and within scope.

Examples:

- Rage
- Ki Points
- Sorcery Points
- Bardic Inspiration
- Channel Divinity
- Hit Dice
- Spell Slots

Potential model:

```kotlin
data class CharacterResource(
    val name: String,
    val current: Int,
    val maximum: Int
)
```

Example:

```text
Rage: 2 / 4
Ki Points: 4 / 6
Spell Slots (Level 1): 3 / 4
```

---

## Spell Management

Desired functionality:

- Store spells.
- Mark spells as prepared.
- Unmark prepared spells.
- Track spell slots.

Example:

```kotlin
data class CharacterSpell(
    val spell: Spell,
    val prepared: Boolean
)
```

No advanced spellcasting rules engine is required.

---

## Database Vision

### Static Data (Pre-populated)

Loaded when the application is installed.

- Classes
- Features
- Races
- Backgrounds
- Feats
- Items
- Spells

---

### User Data

Created and managed by the user.

- Characters
- Resource usage
- Prepared spells
- Inventory
- Notes

Only user-generated content should be mutable.

---

## Design Principles

### Principle 1

Room is an implementation detail.

The domain should not depend on Room.

---

### Principle 2

Keep the application focused on replacing a paper sheet.

Avoid implementing rules that provide little practical value.

---

### Principle 3

Prefer manual overrides to complicated automation.

If a player can reasonably adjust a value themselves, that is often preferable to implementing complex game logic.

---

### Principle 4

The application should help players track information, not play the game for them.

---

## Immediate Roadmap

### Phase 1

- Room setup
- Class entities
- Feature entities
- Relations between classes and features
- Initial data population

### Phase 2

- Character creation
- Character persistence
- Character editing

### Phase 3

- Resource tracking
- Spell slot tracking
- Prepared spells

### Phase 4

- Inventory system
- Equipment management
- Character notes

---

## Project Goal Summary

The question that should guide every feature:

> Does this help replace a paper character sheet during an actual D&D session?

If the answer is yes, it is probably worth implementing.

If it starts turning the application into a complete D&D rules engine, reconsider or simplify the feature.