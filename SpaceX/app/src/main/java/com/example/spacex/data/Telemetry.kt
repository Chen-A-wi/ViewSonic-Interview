package com.example.spacex.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Telemetry(
    @Json(name = "flight_club")
    val flightClub: String?
)