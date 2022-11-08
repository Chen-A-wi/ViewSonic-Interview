package com.example.spacex.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class DataAdapter {
    @ToJson
    fun toJson(type: DataType): String = type.value

    @FromJson
    fun fromJson(value: String): DataType = DataType.fromCode(value)
}