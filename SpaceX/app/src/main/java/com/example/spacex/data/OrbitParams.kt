package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class OrbitParams(
    @Json(name = "apoapsis_km")
    val apoapsisKm: Double?,
    @Json(name = "arg_of_pericenter")
    val argOfPericenter: Double?,
    @Json(name = "eccentricity")
    val eccentricity: Double?,
    @Json(name = "epoch")
    val epoch: String?,
    @Json(name = "inclination_deg")
    val inclinationDeg: Double?,
    @Json(name = "lifespan_years")
    val lifespanYears: Double?,
    @Json(name = "longitude")
    val longitude: Double?,
    @Json(name = "mean_anomaly")
    val meanAnomaly: Double?,
    @Json(name = "mean_motion")
    val meanMotion: Double?,
    @Json(name = "periapsis_km")
    val periapsisKm: Double?,
    @Json(name = "period_min")
    val periodMin: Double?,
    @Json(name = "raan")
    val raan: Double?,
    @Json(name = "reference_system")
    val referenceSystem: String?,
    @Json(name = "regime")
    val regime: String?,
    @Json(name = "semi_major_axis_km")
    val semiMajorAxisKm: Double?
) : Parcelable