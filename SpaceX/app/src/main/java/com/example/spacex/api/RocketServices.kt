package com.example.spacex.api

import com.example.spacex.data.RocketDataItem
import retrofit2.Response
import retrofit2.http.GET

interface RocketServices {
    @GET("/v3/launches")
    suspend fun getLaunches(): Response<List<RocketDataItem>>
}