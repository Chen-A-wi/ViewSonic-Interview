package com.example.spacex.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "article_link")
    val articleLink: String?,
    @Json(name = "flickr_images")
    val flickrImages: List<String>?,
    @Json(name = "mission_patch")
    val missionPatch: String?,
    @Json(name = "mission_patch_small")
    val missionPatchSmall: String?,
    @Json(name = "presskit")
    val presskit: String?,
    @Json(name = "reddit_campaign")
    val redditCampaign: String?,
    @Json(name = "reddit_launch")
    val redditLaunch: String?,
    @Json(name = "reddit_media")
    val redditMedia: String?,
    @Json(name = "reddit_recovery")
    val redditRecovery: String?,
    @Json(name = "video_link")
    val videoLink: String?,
    @Json(name = "wikipedia")
    val wikipedia: String?,
    @Json(name = "youtube_id")
    val youtubeId: String?
) : Parcelable