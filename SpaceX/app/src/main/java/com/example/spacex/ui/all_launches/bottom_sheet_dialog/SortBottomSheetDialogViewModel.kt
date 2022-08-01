package com.example.spacex.ui.all_launches.bottom_sheet_dialog

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.spacex.common.SortType
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.ui.base.BaseViewModel

class SortBottomSheetDialogViewModel : BaseViewModel() {
    val isSort = MutableLiveData(false)
    val isReversed = MutableLiveData(false)
    val clickLiveEvent = SingleLiveEvent<Int>()

    fun initData(sortType: SortType) {
        if (sortType == SortType.SORT) {
            isSort.value = true
            isReversed.value = false
        } else {
            isSort.value = false
            isReversed.value = true
        }
    }

    fun onClick(v: View) {
        clickLiveEvent.postValue(v.id)
    }
}