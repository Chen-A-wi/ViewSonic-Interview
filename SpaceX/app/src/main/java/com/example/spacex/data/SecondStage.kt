package com.example.spacex.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SecondStage(
    @Json(name = "block")
    val block: Int?,
    @Json(name = "payloads")
    val payloads: List<Payload>?
)