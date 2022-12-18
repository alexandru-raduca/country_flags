package com.daniel.raduca.countryflags.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Query("SELECT * FROM countries")
    fun countries(): Flow<List<Country>>

    @Query("DELETE FROM countries")
    suspend fun deleteCountries()
}

@Database(entities = [Country::class], version = 1)
abstract class CountriesDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
