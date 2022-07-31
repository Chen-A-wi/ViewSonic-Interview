package com.example.spacex.ui.all_launches

import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.spacex.common.utils.SchedulerProvider
import com.example.spacex.common.utils.SingleLiveEvent
import com.example.spacex.repository.RocketRepository
import com.example.spacex.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class AllLaunchesViewModel(
    private val repository: RocketRepository,
    private val scheduler: SchedulerProvider
) : BaseViewModel() {
    val clickLiveEvent = SingleLiveEvent<Int>()

    fun onClick(v: View) {
        clickLiveEvent.postValue(v.id)
    }

    init {
        getRocketLaunches()
    }

    fun getRocketLaunches() {
        isLoading.postValue(true)

        viewModelScope.launch {
            repository.getRocketLaunches()
                .flowOn(scheduler.io())
                .catch { e ->
                    Log.e("API Error", e.message.orEmpty())
                }
                .collect { response ->
                    if (response.isSuccessful) {
                        Log.d("=============", "${response.body()}")
                    } else {
                        Log.e("=============", response.errorBody().toString())
                    }
                    isLoading.postValue(false)
                }
        }
    }
}