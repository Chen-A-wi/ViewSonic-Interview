package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Rocket(
    @Json(name = "fairings")
    val fairings: Fairings?,
    @Json(name = "first_stage")
    val firstStage: FirstStage?,
    @Json(name = "rocket_id")
    val rocketId: String?,
    @Json(name = "rocket_name")
    val rocketName: String?,
    @Json(name = "rocket_type")
    val rocketType: String?,
    @Json(name = "second_stage")
    val secondStage: SecondStage?
) : Parcelable