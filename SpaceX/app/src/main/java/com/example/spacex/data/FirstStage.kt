package com.example.spacex.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FirstStage(
    @Json(name = "cores")
    val cores: List<Core>?
)