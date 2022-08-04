package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RocketDataItem(
    @Json(name = "details")
    val details: String?,
    @Json(name = "flight_number")
    val flightNumber: Int?,
    @Json(name = "is_tentative")
    val isTentative: Boolean?,
    @Json(name = "last_date_update")
    val lastDateUpdate: String?,
    @Json(name = "last_ll_launch_date")
    val lastLlLaunchDate: String?,
    @Json(name = "last_ll_update")
    val lastLlUpdate: String?,
    @Json(name = "last_wiki_launch_date")
    val lastWikiLaunchDate: String?,
    @Json(name = "last_wiki_revision")
    val lastWikiRevision: String?,
    @Json(name = "last_wiki_update")
    val lastWikiUpdate: String?,
    @Json(name = "launch_date_local")
    val launchDateLocal: String?,
    @Json(name = "launch_date_source")
    val launchDateSource: String?,
    @Json(name = "launch_date_unix")
    val launchDateUnix: Int?,
    @Json(name = "launch_date_utc")
    val launchDateUtc: String?,
    @Json(name = "launch_failure_details")
    val launchFailureDetails: LaunchFailureDetails?,
    @Json(name = "launch_site")
    val launchSite: LaunchSite?,
    @Json(name = "launch_success")
    val launchSuccess: Boolean?,
    @Json(name = "launch_window")
    val launchWindow: Int?,
    @Json(name = "launch_year")
    val launchYear: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "mission_id")
    val missionId: List<String>?,
    @Json(name = "mission_name")
    val missionName: String?,
    @Json(name = "rocket")
    val rocket: Rocket?,
    @Json(name = "ships")
    val ships: List<String>?,
    @Json(name = "static_fire_date_unix")
    val staticFireDateUnix: Int?,
    @Json(name = "static_fire_date_utc")
    val staticFireDateUtc: String?,
    @Json(name = "tbd")
    val tbd: Boolean?,
    @Json(name = "telemetry")
    val telemetry: Telemetry?,
    @Json(name = "tentative_max_precision")
    val tentativeMaxPrecision: String?,
    @Json(name = "timeline")
    val timeline: Timeline?,
    @Json(name = "upcoming")
    val upcoming: Boolean?
) : Parcelable