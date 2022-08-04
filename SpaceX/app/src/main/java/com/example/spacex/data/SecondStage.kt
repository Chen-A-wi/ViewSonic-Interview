package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class SecondStage(
    @Json(name = "block")
    val block: Int?,
    @Json(name = "payloads")
    val payloads: List<Payload>?
) : Parcelable