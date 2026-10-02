# 5SheetManager

5SheetManager is an offline-first Android application for managing Dungeons & Dragons 5th Edition (2014) character sheets.

The project aims to provide a complete character management experience without requiring an internet connection. All official game data required to create and manage characters is stored locally in a Room database and shipped with the application.

## Features
Offline character creation and management
Full D&D 5e (2014) rules reference stored locally
Support for classes, subclasses, races, backgrounds, feats, items and spells
Character progression and level tracking
Automatic calculation of derived statistics
Character inventory management
Spell preparation and spell slot tracking
Local persistence using Room
Fast startup through pre-populated static data
## Architecture

The application follows modern Android development practices:

Kotlin
Jetpack Compose
Room
Coroutines
Flow
MVI
Clean Architecture
## Database Design

The database contains two categories of data:

## Static Game Data

Pre-populated when the application is installed:

Classes
Subclasses
Features
Feature progressions
Backgrounds
Races
Feats
Items
Spells
## User Data

Created and managed by the user:

Characters
Character inventory
Character spells
Character progression choices
Equipment configuration

Only user-generated content is persisted during gameplay. Rules data remains immutable and can be updated through database migrations when new content is added.

## Goal

The ultimate goal is to build a reliable offline companion capable of handling the complete D&D 5e (2014) character lifecycle, from character creation to level 20 progression.
