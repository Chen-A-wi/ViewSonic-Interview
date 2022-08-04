package com.example.spacex.common

object DateTimeFormatPattern {

    private const val PATTERN_MONTH = "MMM"

    const val TIME_FORMAT_H_M_S = "HH:mm:ss"

    const val DATE_FORMAT = "yyyy/MM/dd"
    const val DATE_FORMAT_EN = "$PATTERN_MONTH/dd/yyyy"

    const val DATE_TIME_FORMAT = "$DATE_FORMAT $TIME_FORMAT_H_M_S"
    const val DATE_TIME_FORMAT_EN = "$DATE_FORMAT_EN $TIME_FORMAT_H_M_S"
}
