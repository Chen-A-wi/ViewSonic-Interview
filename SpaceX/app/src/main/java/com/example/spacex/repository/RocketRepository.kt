package com.example.spacex.repository

import com.example.spacex.api.RocketServices
import com.example.spacex.data.RocketDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class RocketRepository(private val services: RocketServices) {
    fun getRocketLaunches(): Flow<Response<List<RocketDataItem>>> {
        return flow {
            emit(services.getLaunches())
        }
    }
}