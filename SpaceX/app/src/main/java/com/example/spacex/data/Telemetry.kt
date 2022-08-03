package com.example.spacex.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Telemetry(
    @Json(name = "flight_club")
    val flightClub: String?
) : Parcelable