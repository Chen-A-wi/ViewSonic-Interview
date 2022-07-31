package com.example.spacex.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Core(
    @Json(name = "block")
    val block: Int?,
    @Json(name = "core_serial")
    val coreSerial: String?,
    @Json(name = "flight")
    val flight: Int?,
    @Json(name = "gridfins")
    val gridfins: Boolean?,
    @Json(name = "land_success")
    val landSuccess: Boolean?,
    @Json(name = "landing_intent")
    val landingIntent: Boolean?,
    @Json(name = "landing_type")
    val landingType: String?,
    @Json(name = "landing_vehicle")
    val landingVehicle: String?,
    @Json(name = "legs")
    val legs: Boolean?,
    @Json(name = "reused")
    val reused: Boolean?
)