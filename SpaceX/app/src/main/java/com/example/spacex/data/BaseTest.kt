package com.example.spacex.data

import android.os.Parcelable
import com.example.spacex.common.ErrorType
import com.example.spacex.common.ext.fromType
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

enum class DataType(val value: String) {
    DATA_LIST("data_list"), DATA_STRING("data_string"), UNKNOWN("unknown");

    companion object {
        fun fromCode(value: String): DataType = DataType::value.fromType(
            value,
            UNKNOWN
        )
    }
}

@JsonClass(generateAdapter = true)
data class BaseTest<D>(
    val dataType: DataType? = DataType.UNKNOWN,
    val data: D?
)

@JsonClass(generateAdapter = true)
data class PageItem(
    val title: String,
    val content: String
)
