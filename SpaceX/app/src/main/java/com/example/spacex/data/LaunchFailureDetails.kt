package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LaunchFailureDetails(
    @Json(name = "altitude")
    val altitude: Int?,
    @Json(name = "reason")
    val reason: String?,
    @Json(name = "time")
    val time: Int?
) : Parcelable