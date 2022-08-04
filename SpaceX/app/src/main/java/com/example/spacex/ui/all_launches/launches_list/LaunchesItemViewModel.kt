package com.example.spacex.ui.all_launches.launches_list

import androidx.lifecycle.MutableLiveData
import com.example.spacex.data.RocketDataItem
import com.example.spacex.ui.base.BaseViewModel

class LaunchesItemViewModel(
    itemData: RocketDataItem, private val onItemClick: (() -> Unit)
) : BaseViewModel() {
    val flightNo = MutableLiveData(itemData.flightNumber.toString())
    val imgUrl = MutableLiveData(itemData.links?.missionPatchSmall.orEmpty())
    val missionName = MutableLiveData(itemData.missionName)
    val launchDate = MutableLiveData(itemData.launchDateUtc)


    fun onClick() {
        onItemClick.invoke()
    }
}