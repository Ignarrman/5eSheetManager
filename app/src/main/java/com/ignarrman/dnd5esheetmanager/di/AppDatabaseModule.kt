package com.ignarrman.dnd5esheetmanager.di

import android.content.Context
import androidx.room.Room
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BardicInspirationProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object AppDatabaseModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseModule {

        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "dnd5e.db"
            ).build()

        @Provides
        fun provideClassDao(
            database: AppDatabase
        ): ClassDao = database.classDao()

        @Provides
        fun provideFeatureDao(
            database: AppDatabase
        ): FeatureDao = database.featureDao()

        @Provides
        fun provideBarbarianProgressionDao(
            database: AppDatabase
        ): BarbarianProgressionDao =
            database.barbarianProgressionDao()

        @Provides
        fun provideBardicInspirationProgressionDao(
            database: AppDatabase
        ): BardicInspirationProgressionDao =
            database.bardicInspirationProgressionDao()

        @Provides
        fun provideSpellcastingDao(
            database: AppDatabase
        ): SpellcastingDao =
            database.spellcastingDao()
    }
}