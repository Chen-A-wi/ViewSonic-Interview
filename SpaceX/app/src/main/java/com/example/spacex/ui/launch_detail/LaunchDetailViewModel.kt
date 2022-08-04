package com.example.spacex.ui.launch_detail

import androidx.lifecycle.MutableLiveData
import com.example.spacex.common.ext.localDateTimeFromISO
import com.example.spacex.common.ext.text
import com.example.spacex.data.RocketDataItem
import com.example.spacex.ui.base.BaseViewModel

class LaunchDetailViewModel(rocketDataItem: RocketDataItem) : BaseViewModel() {
    val imgUrl = MutableLiveData(rocketDataItem.links?.missionPatchSmall.orEmpty())
    val flightNo = MutableLiveData(rocketDataItem.flightNumber.toString())
    val missionName = MutableLiveData(rocketDataItem.missionName.orEmpty())
    val launchLocalDate =
        MutableLiveData(rocketDataItem.launchDateLocal?.localDateTimeFromISO?.text().orEmpty())
    val launchSite = MutableLiveData(rocketDataItem.launchSite?.siteName.orEmpty())
}