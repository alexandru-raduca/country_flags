package com.daniel.raduca.countryflags.di

import android.content.Context
import androidx.room.Room
import com.daniel.raduca.countryflags.database.CountriesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): CountriesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CountriesDatabase::class.java,
            "countries.db"
        ).build()
    }
}