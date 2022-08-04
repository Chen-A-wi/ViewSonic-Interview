package com.example.spacex.common.ext

import com.example.spacex.common.DateTimeFormatPattern
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

val String.localDateTimeFromISO: LocalDateTime
    get() = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)

/**
 * @return
 * 英文: 05/04/2021 11:22:33
 * 中/日 文: 2021/05/04 11:22:33
 */
fun LocalDateTime.text(locale: Locale = Locale.getDefault()): String {
    val pattern = when (locale.language) {
        "en" -> DateTimeFormatPattern.DATE_TIME_FORMAT_EN
        else -> DateTimeFormatPattern.DATE_TIME_FORMAT
    }
    return format(DateTimeFormatter.ofPattern(pattern, locale))
}