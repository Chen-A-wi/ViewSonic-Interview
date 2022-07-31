package com.example.spacex.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Timeline(
    @Json(name = "beco")
    val beco: Int?,
    @Json(name = "center_core_entry_burn")
    val centerCoreEntryBurn: Int?,
    @Json(name = "center_core_landing")
    val centerCoreLanding: Int?,
    @Json(name = "center_stage_sep")
    val centerStageSep: Int?,
    @Json(name = "engine_chill")
    val engineChill: Int?,
    @Json(name = "fairing_deploy")
    val fairingDeploy: Int?,
    @Json(name = "go_for_launch")
    val goForLaunch: Int?,
    @Json(name = "go_for_prop_loading")
    val goForPropLoading: Int?,
    @Json(name = "ignition")
    val ignition: Int?,
    @Json(name = "liftoff")
    val liftoff: Int?,
    @Json(name = "maxq")
    val maxq: Int?,
    @Json(name = "meco")
    val meco: Int?,
    @Json(name = "payload_deploy")
    val payloadDeploy: Int?,
    @Json(name = "prelaunch_checks")
    val prelaunchChecks: Int?,
    @Json(name = "propellant_pressurization")
    val propellantPressurization: Int?,
    @Json(name = "seco-1")
    val seco1: Int?,
    @Json(name = "seco-2")
    val seco2: Int?,
    @Json(name = "seco-3")
    val seco3: Int?,
    @Json(name = "seco-4")
    val seco4: Int?,
    @Json(name = "second_stage_ignition")
    val secondStageIgnition: Int?,
    @Json(name = "second_stage_restart")
    val secondStageRestart: Int?,
    @Json(name = "side_core_boostback")
    val sideCoreBoostback: Int?,
    @Json(name = "side_core_entry_burn")
    val sideCoreEntryBurn: Int?,
    @Json(name = "side_core_landing")
    val sideCoreLanding: Int?,
    @Json(name = "side_core_sep")
    val sideCoreSep: Int?,
    @Json(name = "stage1_lox_loading")
    val stage1LoxLoading: Int?,
    @Json(name = "stage1_rp1_loading")
    val stage1Rp1Loading: Int?,
    @Json(name = "stage2_lox_loading")
    val stage2LoxLoading: Int?,
    @Json(name = "stage2_rp1_loading")
    val stage2Rp1Loading: Int?,
    @Json(name = "webcast_liftoff")
    val webcastLiftoff: Int?
)