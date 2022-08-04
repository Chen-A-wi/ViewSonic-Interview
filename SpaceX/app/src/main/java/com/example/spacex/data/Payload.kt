package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Payload(
    @Json(name = "customers")
    val customers: List<String>?,
    @Json(name = "manufacturer")
    val manufacturer: String?,
    @Json(name = "nationality")
    val nationality: String?,
    @Json(name = "norad_id")
    val noradId: List<Int>?,
    @Json(name = "orbit")
    val orbit: String?,
    @Json(name = "orbit_params")
    val orbitParams: OrbitParams?,
    @Json(name = "payload_id")
    val payloadId: String?,
    @Json(name = "payload_mass_kg")
    val payloadMassKg: Double?,
    @Json(name = "payload_mass_lbs")
    val payloadMassLbs: Double?,
    @Json(name = "payload_type")
    val payloadType: String?,
    @Json(name = "reused")
    val reused: Boolean?
) : Parcelable