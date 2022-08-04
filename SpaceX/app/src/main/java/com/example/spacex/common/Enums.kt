package com.example.spacex.common

import com.example.spacex.R
import com.example.spacex.common.ext.fromType

// If have error type add here.
enum class ErrorType {
    UNKNOWN_ERROR;

    val code
        get() = when (this) {
            UNKNOWN_ERROR -> -1
        }

    val resString
        get() = when (this) {
            UNKNOWN_ERROR -> R.string.lb_api_unknown_error
        }

    companion object {
        fun fromCode(code: Int?): ErrorType = ErrorType::code.fromType(code, UNKNOWN_ERROR)
    }
}

enum class SortType {
    SORT, REVERSED;

    val resString
        get() = when (this) {
            SORT -> R.string.lb_sort_flight_number
            REVERSED -> R.string.lb_reversed_flight_number
        }
}