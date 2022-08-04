package com.example.spacex.ui.all_launches.launches_list

import androidx.lifecycle.MutableLiveData
import com.example.spacex.common.ext.localDateTimeFromISO
import com.example.spacex.common.ext.text
import com.example.spacex.data.RocketDataItem
import com.example.spacex.ui.base.BaseViewModel

class LaunchesItemViewModel(
    val itemData: RocketDataItem, private val onItemClick: (() -> Unit)
) : BaseViewModel() {
    val flightNo = MutableLiveData(itemData.flightNumber.toString())
    val imgUrl = MutableLiveData(itemData.links?.missionPatchSmall.orEmpty())
    val missionName = MutableLiveData(itemData.missionName)
    val launchDate =
        MutableLiveData(itemData.launchDateLocal?.localDateTimeFromISO?.text().orEmpty())

    fun onClick() {
        onItemClick.invoke()
    }
}