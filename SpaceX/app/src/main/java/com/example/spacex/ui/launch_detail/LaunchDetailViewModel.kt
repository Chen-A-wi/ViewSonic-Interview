package com.example.spacex.ui.launch_detail

import android.util.Log
import com.example.spacex.data.RocketDataItem
import com.example.spacex.ui.base.BaseViewModel

class LaunchDetailViewModel(rocketDataItem: RocketDataItem) : BaseViewModel() {
    init {
        Log.d("============", "$rocketDataItem")
    }
}