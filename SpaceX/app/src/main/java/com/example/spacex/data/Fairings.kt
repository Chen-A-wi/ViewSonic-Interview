package com.example.spacex.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Fairings(
    @Json(name = "recovered")
    val recovered: Boolean?,
    @Json(name = "recovery_attempt")
    val recoveryAttempt: Boolean?,
    @Json(name = "reused")
    val reused: Boolean?,
    @Json(name = "ship")
    val ship: String?
) : Parcelable