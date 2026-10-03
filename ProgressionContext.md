# Progression Context

## Project Goal

This project is an Android application intended to replace the physical D&D 5e (2014) character sheet.

The goal is **not** to implement D&D rules or become a D&D Beyond replacement.

The application should work as a **digital character sheet and resource-management tool**:

* Display character information.
* Display class, race, background, features and other reference information.
* Display level-based class progressions.
* Display spellcasting information.
* Track resources and their current usage.
* Manage prepared/known spells as entered by the player.
* Manage inventory, equipment and notes.
* Make the information of a character easily accessible during a game.

The player remains responsible for applying the actual D&D rules.

For example, the application should **not** automatically determine how many spells a character can prepare, automatically add racial spells, validate whether a character is legal according to the rules, or calculate other rule-dependent consequences.

If something is part of the character sheet, the user can enter or manage it manually.

> **The app represents and manages the character sheet; it does not enforce the D&D rules.**

---

# Architecture

The project follows Clean Architecture principles:

* **Domain**: game concepts and character-sheet models.
* **Data**: Room database, entities, DAOs, repositories and mappers.
* **Presentation**: Compose UI and MVI-oriented state management.

The domain should remain independent from Room and Android-specific implementation details.

The current domain model intentionally contains **reference data and character-sheet concepts**, not a complete rules engine.

---

# Reference Data vs Character Data

A key distinction in the application is between static/reference information and user-owned character information.

## Reference data

Reference data describes the information available in the game:

* Classes
* Class features
* Class progressions
* Fighting styles
* Eldritch Invocations
* Spellcasting progressions
* Races
* Backgrounds
* Feats
* Items
* Spells
* Other reusable game information

This information is suitable for storage in Room.

## Character data

Character data represents what the player has actually entered or selected for their character:

* Character level
* Ability scores
* Features possessed by the character
* Selected fighting style
* Selected Eldritch Invocations
* Known/prepared spells
* Spell/resource usage
* Inventory
* Equipment
* Notes
* Manual values and overrides

The application should not assume that every piece of reference information automatically applies to a character.

For example, a race may provide a feature according to the D&D rules, but the application should not necessarily add that feature automatically. The player can add it to the character sheet manually.

---

# Class Progression Model

Class progression is represented as data indexed by character level.

The general structure is:

```kotlin
Map<Int, List<Feature>>
```

where the key is the class level.

Example:

```text
1 → [Feature A, Feature B]
2 → [Feature C]
3 → [Feature D, Feature E]
```

This represents **what information is associated with each level**, rather than implementing what happens mechanically when the character reaches that level.

The `Feature` model is intentionally simple:

```kotlin
data class Feature(
    val name: String,
    val description: String,
)
```

Features are descriptive information that can be displayed to the player.

They should not contain executable game rules.

---

# Numeric Class Progressions

Some classes have level-based numerical information in addition to their features.

For these cases, a class-specific progression model can be used:

```kotlin
Map<Int, XProgression>
```

For example:

```kotlin
data class FighterProgression(
    val actionSurgeUses: Int,
    val indomitableUses: Int
)
```

This represents the values shown in the class progression table.

The `XProgression` pattern should be used for **structured level-based reference data**, not as a mechanism for implementing game rules.

A progression object should remain simple while its values are only data.

There is currently no need to split every individual value into its own progression class.

For example, `Action Surge` and `Indomitable` can remain fields of `FighterProgression` while they are simply numerical progression values.

If a concept later requires substantially more information of its own, it can be extracted into a dedicated model.

---

# PlayerClass

The common class model currently contains:

```kotlin
open class PlayerClass(
    open val name: String,
    open val hitDice: Int,
    open val features: Map<Int, List<Feature>>,
    open val fightingStyles: List<FightingStyle> = emptyList(),
    open val spellcasting: Spellcasting = Spellcasting.NonCaster
)
```

The defaults are intentional.

A class that does not have fighting styles does not need to declare an empty list explicitly.

Likewise, a non-spellcasting class can use:

```kotlin
Spellcasting.NonCaster
```

instead of having to define an artificial spellcasting progression.

Class-specific concepts should remain in their specific class when they are not shared by the base class.

For example, Eldritch Invocations are specific to Warlock and therefore belong to `Warlock`, rather than being part of `PlayerClass`.

---

# Fighting Styles

Fighting styles are represented as reusable reference data:

```kotlin
data class FightingStyle(
    val name: String,
    val description: String
)
```

They are not an enum because the application needs to represent them as reference data that can later live in Room.

A class can expose the fighting styles available to it:

```kotlin
List<FightingStyle>
```

This also allows different classes or subclasses to have different available selections without hardcoding the styles into an enum.

The class model describes **available fighting styles**.

The character model will later store the style actually selected by the player.

The application does not need to validate whether the selection is legal according to the D&D rules unless that is explicitly desired in the future. The current goal is to provide the information and let the player manage the sheet.

---

# Spellcasting

Spellcasting is represented by a shared model because several classes need to expose similar spellcasting information.

Current model:

```kotlin
open class Spellcasting(
    val spellcastingAbility: AbilityScores,
    val cantripProgression: Map<Int, CantripProgression>,
    val spellSlotProgression: Map<Int, SpellSlotProgression>,
    val spellsKnown: Map<Int, Int>,
)
```

With:

```kotlin
data class CantripProgression(
    val known: Int
)

data class SpellSlotProgression(
    val slots: Map<Int, Int>
)
```

This model represents the **information displayed on a character sheet**.

It does not implement the rules for spellcasting.

For example, `spellSlotProgression` represents the slot progression that should be displayed for a class at each level. It does not determine when slots are consumed, restored, or otherwise used according to the D&D rules.

Likewise, `spellsKnown` is reference information. It does not automatically add spells to a character or enforce how many spells a character may actually have.

---

# Non-Caster Spellcasting

Classes without spellcasting use:

```kotlin
Spellcasting.NonCaster
```

as the default value.

Currently this is represented by the companion object:

```kotlin
companion object NonCaster: Spellcasting(
    spellcastingAbility = AbilityScores.INT,
    cantripProgression = emptyMap(),
    spellSlotProgression = emptyMap(),
    spellsKnown = emptyMap()
)
```

The `INT` value is not intended to mean that non-casters use Intelligence for spellcasting.

It is simply the value used by the current non-caster representation because the `Spellcasting` model currently expects a `spellcastingAbility`.

The empty progressions are the important semantic part:

* No cantrips.
* No spell slots.
* No spells-known progression.

If the model later needs a stronger distinction between caster and non-caster states, `Spellcasting` could be converted into a sealed hierarchy. This is not currently necessary.

---

# Pact Magic

Warlock spellcasting uses the same spellcasting data model for the moment.

Pact Magic has mechanical differences from the standard spellcasting system, but those rules are deliberately outside the scope of this application.

The application only needs to represent the information that should appear on the character sheet.

Therefore, Pact Magic can currently be represented through the existing `spellSlotProgression` structure.

For example, a progression can contain the appropriate number and level of slots for a Warlock without requiring a separate Pact Magic rules engine.

This is intentional.

> `Spellcasting` represents spellcasting information, not spellcasting mechanics.

If the UI eventually needs additional Pact Magic-specific information to display, it can be added as data without turning the application into a rules engine.

---

# Warlock and Eldritch Invocations

Eldritch Invocations are specific to Warlock.

The `Warlock` model therefore contains its own invocation information rather than exposing it through `PlayerClass`.

Reference invocations are represented by:

```kotlin
data class EldritchInvocation(
    val name: String,
    val description: String
)
```

Warlock also contains:

```kotlin
val eldritchInvocationsKnown: Map<Int, Int>
```

This represents the number of invocations known at each Warlock level.

There are three different concepts involved:

1. **Invocation catalogue**

  * Which Eldritch Invocations exist.
  * Their names and descriptions.

2. **Warlock progression**

  * How many invocations can be known at each level.

3. **Character selection**

  * Which specific invocations the player's Warlock has selected.

These should remain separate.

The progression and catalogue belong to reference data.

The selected invocations belong to the character.

The application does not need to automatically select or validate invocations for the player.

---

# IDs and Persistence

IDs do not need to exist in the domain model unless they have an actual domain meaning.

Reference data will eventually live in Room and can use database-specific IDs.

For example, Room may use:

* Primary keys
* Foreign keys
* Junction tables
* IDs linking classes to features
* IDs linking classes to fighting styles
* IDs linking Warlocks to available invocations
* IDs linking characters to their selected data

These persistence concerns should remain in the Data layer.

The domain model should represent the concepts themselves rather than anticipating the database schema.

---

# Reference Data Should Be Static

Class progressions, features, fighting styles, invocations, spells and similar information are primarily static reference data.

The application should not hardcode database identifiers into the domain models.

The domain should instead describe the information:

```text
Fighter
 ├── Features by level
 ├── Fighting styles
 └── Fighter progression

Warlock
 ├── Features by level
 ├── Spellcasting progression
 ├── Eldritch Invocation catalogue
 └── Eldritch Invocations known by level
```

The actual persisted representation will be handled by Room.

---

# Character Sheet Philosophy

The most important design principle is that the application should behave like a **digital version of a physical character sheet**.

A physical sheet does not enforce the D&D rules.

The player writes down:

* Their ability scores.
* Their features.
* Their selected spells.
* Their resources.
* Their inventory.
* Their notes.

This application should provide the same freedom while making the information easier to access and manage.

The app can provide reference information to help the player fill in the sheet, but it should not make gameplay decisions for them.

---

# What the Application Does Not Do

The project explicitly does **not** aim to implement:

* Complete D&D 5e rules.
* Character legality validation.
* Automatic character building.
* Automatic racial feature application.
* Automatic class feature application.
* Automatic spell acquisition.
* Automatic spell preparation calculations.
* Automatic feat or multiclass validation.
* Automatic equipment legality checks.
* Combat resolution.
* Dice interpretation.
* Full resource-rule engines.
* A replacement for D&D Beyond.

For example, if a rule says that a character can prepare a certain number of spells, the application may display the relevant reference information, but it does not need to calculate or enforce that number.

The player can manage their prepared spells manually.

Similarly, if a race or class provides a feature, the application can make that feature available as reference data, but the character sheet does not need to automatically acquire it.

---

# Resource Management

Resource management is within the scope of the application.

The application should allow the player to track resources such as:

* Rage uses
* Ki points
* Sorcery Points
* Bardic Inspiration
* Channel Divinity
* Hit Dice
* Spell slots
* Other manually managed class resources

The important distinction is that the application **tracks the resource**, rather than implementing all the rules governing when and why the resource can be spent or recovered.

For example:

```text
Ki: 3 / 5
```

is useful character-sheet information.

Determining whether the player is currently allowed to spend Ki is outside the application's responsibilities.

---

# Spell Management

Spell management is also within scope.

The application can store and display:

* Spells belonging to a character.
* Prepared/unprepared state.
* Spell level.
* Spell descriptions.
* Spell slots and their current usage.

However, the application should not automatically determine:

* How many spells the character is allowed to prepare.
* Which spells the character should know.
* Which spells are automatically granted.
* Whether a spell selection is legal.
* Whether a character satisfies every prerequisite.

Those are D&D rules and remain the player's responsibility.

---

# Current Domain Direction

The current domain model is considered sufficiently mature for the base progression model.

The main concepts currently established are:

```text
PlayerClass
├── name
├── hitDice
├── features
├── fightingStyles
└── spellcasting

Class-specific models
├── Fighter
│   └── FighterProgression
├── Monk
│   └── MonkProgression
├── Warlock
│   ├── Spellcasting
│   ├── EldritchInvocation catalogue
│   └── eldritchInvocationsKnown
└── Other classes
    └── their own progression data when necessary
```

Shared concepts should only be introduced when they are genuinely shared.

Class-specific concepts should remain in the class that owns them.

The model should stay simple and data-oriented.

---

# Current Development Priority

The progression domain model should not be over-engineered further without a concrete requirement.

The next major step is persistence:

1. Define Room entities.
2. Define DAOs.
3. Define repositories.
4. Define mappers between persistence and domain.
5. Populate static reference data.
6. Persist character-specific information.
7. Connect the domain data to the UI.

The database schema can evolve independently from the domain model.

---

# Reference Data Persistence

The initial reference-data persistence layer has now been implemented using Room.

Reference data currently includes:

* Classes
* Class features
* Class-feature relationships
* Class-specific numeric progressions
* Bardic Inspiration progression
* Spellcasting information
* Cantrip progression
* Spells-known progression
* Spell-slot progression

The current persistence architecture is:

```text
Domain
   ↑
Mapper
   ↑
Repository
   ↑
DAO
   ↑
Room / SQLite
```

The domain remains independent from Room-specific entities.

## Reference Data Seeding

Static reference data is populated through a dedicated:

```kotlin
ReferenceDataSeeder
```

The seeder is executed from the application layer rather than from a screen or ViewModel.

This keeps database initialization independent from the UI lifecycle.

The seeder performs all reference-data operations inside a Room transaction.

Conceptually:

```text
Application startup
       ↓
ReferenceDataSeeder
       ↓
Check reference-data version
       ↓
Version unchanged?
   ├── Yes → do nothing
   └── No
        ↓
   Delete reference data
        ↓
   Insert current reference data
        ↓
   Update stored reference-data version
```

The reference-data tables are deliberately separated from future character-owned data.

The seeder must never delete or modify character data.

---

# Reference Data Versioning

Reference data has its own version independent from the Room database schema version.

For example:

```kotlin
const val REFERENCE_DATA_VERSION = 1
```

This version represents the version of the **content** being inserted into the reference-data tables.

It is intentionally different from:

```kotlin
@Database(
    entities = [...],
    version = 1
)
```

The Room database version represents the **database schema** and is responsible for schema migrations.

The reference-data version represents the **static data contained in the database**.

Therefore:

```text
AppDatabase.version
    → Room schema version
    → Tables, columns, keys, relationships, indexes
    → Room migrations

REFERENCE_DATA_VERSION
    → Reference-data content version
    → Classes, features, progressions, spells, etc.
    → ReferenceDataSeeder
```

Changing reference data does not necessarily require changing the Room schema version.

For example, changing a class progression value can require:

```kotlin
REFERENCE_DATA_VERSION = 2
```

without requiring:

```kotlin
AppDatabase.version = 2
```

provided that the database schema itself has not changed.

---

# Reference Data Metadata

The current reference-data version is stored in Room through dedicated metadata:

```kotlin
ReferenceDataMetadataEntity
```

with:

```kotlin
ReferenceDataMetadataDao
```

The metadata identifies the stored reference-data version.

The seeder compares the stored version with the version defined by the application.

If they match, no work is performed.

If they differ, the reference data is rebuilt.

This avoids relying on the number of rows in a table as an indication that the database has already been seeded.

---

# Reference Data Replacement

When the reference-data version changes, the existing reference data is removed before the new version is inserted.

Only reference-data tables are affected.

The intermediate `class_features` table is also explicitly cleared because it contains relationships between reference-data entities.

The deletion order respects the relationships between the tables:

```text
Dependent data
    ↓
Junction / relationship data
    ↓
Parent reference data
```

The complete operation is performed inside a single transaction.

Therefore, if the new reference data cannot be inserted completely, the previous transaction is rolled back instead of leaving the database partially populated.

This replacement strategy is intentionally limited to reference data.

Character data will remain persistent across reference-data updates.

---

# Current Persistence Status

The following persistence infrastructure is now established:

* Room database configuration
* Reference-data entities
* Reference-data DAOs
* Class/feature junction table
* Class-specific progression tables
* Spellcasting persistence
* Persistence-to-domain mappers
* Class repository
* Hilt database dependency injection
* Application-level reference-data seeding
* Reference-data metadata and versioning
* Transactional reference-data replacement

The current implementation is intentionally focused on the reference-data side of the application.

Character persistence has not yet been implemented.

---

# Next Development Step

The next major persistence task is to design the **character data model**.

This should remain separate from reference data.

Reference data answers:

```text
"What information exists in the game?"
```

Character data answers:

```text
"What has the player written or selected for this character?"
```

The character model should therefore store the player's actual state without assuming that every piece of reference data automatically applies to the character.

The existing principle remains:

> **Reference data describes what is available. Character data describes what the player has chosen or entered.**


# Guiding Principle

The project should always favor:

> **A useful digital character sheet over a complete implementation of D&D.**

If a piece of functionality can be represented as information on a physical character sheet, it is probably within scope.

If it requires the application to understand, enforce or execute D&D rules, it is probably outside scope.

The application exists so that players do not have to remember where they left their physical character sheets — not to become another D&D rules platform.
