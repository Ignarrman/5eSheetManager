package com.ignarrman.dnd5esheetmanager.di

import android.content.Context
import androidx.room.Room
import com.ignarrman.dnd5esheetmanager.data.local.AppDatabase
import com.ignarrman.dnd5esheetmanager.data.local.daos.FeatureDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.FightingStyleDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.ReferenceDataMetadataDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BarbarianProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.BardicInspirationProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ChannelDivinityProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.ClassDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.EldritchInvocationsKnownProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.EldritchInvocationsProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.FighterProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.InfusionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.InfusionProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.LayOnHandsProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.MetamagicDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.MonkProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.SneakAttackProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.SorceryPointProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.classesdao.WildShapeProgressionDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellDao
import com.ignarrman.dnd5esheetmanager.data.local.daos.spellsdao.SpellcastingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

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
    ): ClassDao =
        database.classDao()

    @Provides
    fun provideFeatureDao(
        database: AppDatabase
    ): FeatureDao =
        database.featureDao()

    @Provides
    fun provideFightingStyleDao(
        database: AppDatabase
    ): FightingStyleDao =
        database.fightingStyleDao()

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
    fun provideChannelDivinityProgressionDao(
        database: AppDatabase
    ): ChannelDivinityProgressionDao =
        database.channelDivinityProgressionDao()

    @Provides
    fun provideFighterProgressionDao(
        database: AppDatabase
    ): FighterProgressionDao =
        database.fighterProgressionDao()

    @Provides
    fun provideInfusionDao(
        database: AppDatabase
    ): InfusionDao =
        database.infusionDao()

    @Provides
    fun provideInfusionProgressionDao(
        database: AppDatabase
    ): InfusionProgressionDao =
        database.infusionProgressionDao()

    @Provides
    fun provideLayOnHandsProgressionDao(
        database: AppDatabase
    ): LayOnHandsProgressionDao =
        database.layOnHandsProgressionDao()

    @Provides
    fun provideMonkProgressionDao(
        database: AppDatabase
    ): MonkProgressionDao =
        database.monkProgressionDao()

    @Provides
    fun provideSneakAttackProgressionDao(
        database: AppDatabase
    ): SneakAttackProgressionDao =
        database.sneakAttackProgressionDao()

    @Provides
    fun provideSorceryPointProgressionDao(
        database: AppDatabase
    ): SorceryPointProgressionDao =
        database.sorceryPointProgressionDao()

    @Provides
    fun provideMetamagicDao(
        database: AppDatabase
    ): MetamagicDao =
        database.metamagicDao()

    @Provides
    fun provideWildShapeProgressionDao(
        database: AppDatabase
    ): WildShapeProgressionDao =
        database.wildShapeProgressionDao()

    @Provides
    fun provideEldritchInvocationsProgressionDao(
        database: AppDatabase
    ): EldritchInvocationsProgressionDao =
        database.eldritchInvocationsProgressionDao()

    @Provides
    fun provideEldritchInvocationsKnownProgressionDao(
        database: AppDatabase
    ): EldritchInvocationsKnownProgressionDao =
        database.eldritchInvocationsKnownProgressionDao()

    @Provides
    fun provideSpellCastingDao(
        database: AppDatabase
    ): SpellcastingDao =
        database.spellcastingDao()

    @Provides
    fun provideSpellDao(
        database: AppDatabase
    ): SpellDao =
        database.spellDao()

    @Provides
    fun provideReferenceDataMetadataDao(
        database: AppDatabase
    ): ReferenceDataMetadataDao =
        database.referenceDataMetadataDao()
}