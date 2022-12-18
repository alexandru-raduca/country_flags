package com.daniel.raduca.countryflags.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "name") val name: Name?,
    @Json(name = "independent") val independent: Boolean?,
    @Json(name = "status") val status: String?,
    @Json(name = "capital") val capitals: List<String>?,
    @Json(name = "region") val region: String?,
    @Json(name = "subregion") val subregion: String?,
    @Json(name = "continents") val continents: List<String>?,
    @Json(name = "area") val area: Double?,
    @Json(name = "population") val population: Long?,
    @Json(name = "maps") val maps: Maps?,
    @Json(name = "car") val car: Car?,
    @Json(name = "flags") val flags: Flags?,
    @Json(name = "languages") val languages: Map<String, String>?,
    @Json(name = "currencies") val currencies: Map<String, Currency>?
)

data class Name(
    @Json(name = "common") val common: String?,
    @Json(name = "official") val official: String?,
    @Json(name = "nativeName") val nativeName: Map<String, NativeName>?
)

data class NativeName(
    @Json(name = "official") val official: String?,
    @Json(name = "common") val common: String?
)

data class Maps(
    @Json(name = "googleMaps") val googleMaps: String?,
    @Json(name = "openStreetMaps") val openStreetMaps: String?
)

data class Car(
    @Json(name = "side") val side: String?
)

data class Currency(
    @Json(name = "name") val name: String?,
    @Json(name = "symbol") val symbol: String?
)

data class Flags(
    @Json(name = "png") val png: String?,
    @Json(name = "svg") val svg: String?
)