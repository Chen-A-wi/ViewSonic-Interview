package com.example.spacex.ui.all_launches

import android.view.View
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.ui.base.BaseViewModel

class AllLaunchesViewModel : BaseViewModel() {
    val clickLiveEvent = SingleLiveEvent<Int>()

    fun onClick(v: View) {
        clickLiveEvent.postValue(v.id)
    }
}