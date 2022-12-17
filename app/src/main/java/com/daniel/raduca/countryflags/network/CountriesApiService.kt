package com.daniel.raduca.countryflags.network

import com.daniel.raduca.countryflags.model.Country
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://restcountries.com/v3.1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CountriesApiService {
    @GET("all")
    suspend fun getCountries(): List<Country>;

    @GET("name/{name}")
    suspend fun getCountriesByName(@Path("name") name: String): List<Country>;
}

object CountriesApi {
    val retrofitService: CountriesApiService by lazy { retrofit.create(CountriesApiService::class.java) }
}