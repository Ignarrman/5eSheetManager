package com.ignarrman.dnd5esheetmanager.data.local.daos.races

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.races.RaceFeatureCrossRef

@Dao
interface RaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(races: List<RaceEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(race: RaceEntity)

    @Query("SELECT * FROM races ORDER BY name")
    suspend fun getAll(): List<RaceEntity>

    @Query(
        """
    SELECT * FROM races
    WHERE name = :name AND source = :source
    LIMIT 1
    """
    )
    suspend fun getByNameAndSource(
        name: String,
        source: String
    ): RaceEntity?

    @Query("DELETE FROM races")
    suspend fun deleteAll()
    @Query("""
    SELECT features.*
    FROM features
    INNER JOIN race_features
        ON features.id = race_features.featureId
    WHERE race_features.raceId = :raceId
    ORDER BY features.id 
    """)
    suspend fun getFeaturesForRace(raceId: Long): List<FeatureEntity>

    suspend fun insertFeatureRelations(
        relations: List<RaceFeatureCrossRef>
    )

    @Query("DELETE FROM race_features")
    suspend fun deleteAllFeatureRelations()
}